package com.altima.api.mrh

import com.julien.juge.khast.api.config.mvc.WebMvcConfiguration
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@SpringBootApplication
@EnableAutoConfiguration
open class KhastApplication {

    @Bean
    open fun rxJavaWebMvcConfiguration(): WebMvcConfigurerAdapter {
        return WebMvcConfiguration()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(KhastApplication::class.java, *args)
}