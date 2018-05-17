package com.julien.juge.khast.api.config.mvc;

import com.julien.juge.khast.api.config.json.JsonMessageConverter;
import com.julien.juge.khast.api.config.rx.FutureSupport;
import com.julien.juge.khast.api.config.rx.ObservableSupport;
import com.julien.juge.khast.api.config.rx.SingleSupport;
import com.julien.juge.khast.api.config.rx.StreamableObservableSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
import java.util.concurrent.Executors;

public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new JsonMessageConverter());
    }

    @Override
    public void configureAsyncSupport(final AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2)));
        configurer.registerCallableInterceptors(timeoutInterceptor());
    }

    @Bean
    public TimeoutCallableProcessingInterceptor timeoutInterceptor() {
        return new TimeoutCallableProcessingInterceptor();
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        returnValueHandlers.add(new StreamableObservableSupport.MultiObservableReturnValueHandler());
        returnValueHandlers.add(new FutureSupport.FutureReturnValueHandler());
        returnValueHandlers.add(new SingleSupport.SingleReturnValueHandler());
        returnValueHandlers.add(new ObservableSupport.ObservableReturnValueHandler());
    }


}
