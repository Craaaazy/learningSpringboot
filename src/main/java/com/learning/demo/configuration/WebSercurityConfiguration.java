package com.learning.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSercurityConfiguration extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")//默认login
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user").password("").roles("USER");
    }

}
