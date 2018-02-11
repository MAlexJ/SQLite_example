package com.malexj.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Creating The Security Configuration
 * <p>
 * Spring Security configuration
 * https://www.boraji.com/spring-mvc-5-spring-security-5-hibernate-5-example
 * https://justinrodenbostel.com/2014/05/30/part-5-integrating-spring-security-with-spring-boot-web/
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configure user data
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = passwordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password(encoder.encode("password"))
                .roles("USER");
    }

    /**
     * Configure asses to wer resources
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/resources/**", "/webjars/**", "/js/**", "/css/**", "/img/**");
    }

    /**
     * Configuration spring security
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().anyRequest().authenticated();
        http
                .formLogin().failureUrl("/login?error")
                .defaultSuccessUrl("/")
                .loginPage("/login")
                .permitAll()
                .and()
                .authorizeRequests().antMatchers("/login", "/resources/**").hasAnyRole("ANONYMOUS, USER")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login")
                .permitAll()
                .and()
                .csrf().ignoringAntMatchers("/login", "/logout");
    }
}
