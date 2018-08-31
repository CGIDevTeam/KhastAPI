package com.julien.juge.khast.api.utils

import com.auth0.spring.security.api.JwtWebSecurityConfigurer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
open class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Value("\${auth0.audience}")
    private val audience: String? = null

    @Value("\${auth0.issuer}")
    private val issuer: String? = null

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
        http.authorizeRequests().antMatchers("/v1/posts*").authenticated()
        http.authorizeRequests().antMatchers("/v1/users*").authenticated()


        JwtWebSecurityConfigurer
                .forRS256(audience, issuer!!)
                .configure(http)
    }
}