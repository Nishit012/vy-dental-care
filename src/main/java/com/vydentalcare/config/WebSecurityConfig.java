// com.vydentalcare.config.WebSecurityConfig.java

package com.vydentalcare.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/appointment-success", "/submit-appointment","/appointment", "/css/**", "/js/**", "/assets/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
}
