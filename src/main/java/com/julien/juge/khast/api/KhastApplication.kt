package com.julien.juge.khast.api

import com.julien.juge.khast.api.utils.WebSecurityConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableAutoConfiguration
open class KhastApplication {

    @Bean
    open fun rxJavaWebMvcConfiguration(): WebSecurityConfig {
        return WebSecurityConfig()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(KhastApplication::class.java, *args)
}