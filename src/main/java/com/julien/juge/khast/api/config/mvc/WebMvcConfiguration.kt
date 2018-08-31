package com.julien.juge.khast.api.config.mvc

import com.julien.juge.khast.api.config.json.JsonMessageConverter
import com.julien.juge.khast.api.config.rx.FutureSupport
import com.julien.juge.khast.api.config.rx.ObservableSupport
import com.julien.juge.khast.api.config.rx.SingleSupport
import com.julien.juge.khast.api.config.rx.StreamableObservableSupport
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.ByteArrayHttpMessageConverter
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor
import org.springframework.web.method.support.HandlerMethodReturnValueHandler
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import java.util.ArrayList
import java.util.concurrent.Executors

class WebMvcConfiguration : WebMvcConfigurerAdapter() {

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>?) {
        converters!!.add(JsonMessageConverter())
        converters.add(byteArrayHttpMessageConverter())
    }

    override fun configureAsyncSupport(configurer: AsyncSupportConfigurer?) {
        configurer!!.setTaskExecutor(ConcurrentTaskExecutor(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2)))
        configurer.registerCallableInterceptors(timeoutInterceptor())
    }

    @Bean
    fun timeoutInterceptor(): TimeoutCallableProcessingInterceptor {
        return TimeoutCallableProcessingInterceptor()
    }

    @Bean
    fun byteArrayHttpMessageConverter(): ByteArrayHttpMessageConverter {
        val arrayHttpMessageConverter = ByteArrayHttpMessageConverter()
        arrayHttpMessageConverter.supportedMediaTypes = getSupportedMediaTypes()
        return arrayHttpMessageConverter
    }

    private fun getSupportedMediaTypes(): List<MediaType> {
        val list = ArrayList<MediaType>()
        list.add(MediaType.IMAGE_JPEG)
        list.add(MediaType.IMAGE_PNG)
        list.add(MediaType.APPLICATION_OCTET_STREAM)
        return list
    }

    override fun addReturnValueHandlers(returnValueHandlers: MutableList<HandlerMethodReturnValueHandler>?) {
        returnValueHandlers!!.add(StreamableObservableSupport.MultiObservableReturnValueHandler())
        returnValueHandlers.add(FutureSupport.FutureReturnValueHandler())
        returnValueHandlers.add(SingleSupport.SingleReturnValueHandler())
        returnValueHandlers.add(ObservableSupport.ObservableReturnValueHandler())
    }


}
