package com.example.hibernate.HibernateCrashLearning.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security.authorizeRequests()
                .antMatchers("/departments/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .oauth2Login()
                .and().build();
//        return security.csrf().disable()
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers(new AntPathRequestMatcher("/api/author")).permitAll();
//                    auth.anyRequest().authenticated();
//                })
//                .oauth2Login(Customizer.withDefaults())
//                .exceptionHandling()
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                .accessDeniedHandler(new CustomAccessDeniedHandler(objectMapper))
//                .formLogin(Customizer.withDefaults())
//                .and().build();
    }

}