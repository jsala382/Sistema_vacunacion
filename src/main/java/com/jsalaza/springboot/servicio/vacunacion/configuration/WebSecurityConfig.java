package com.jsalaza.springboot.servicio.vacunacion.configuration;

import com.jsalaza.springboot.servicio.vacunacion.services.impl.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
class WebSecurityConfig {

    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http
                .csrf((csrf) -> csrf
                        .disable())
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(HttpMethod.POST, Constans.LOGIN_URL).permitAll()
                        .anyRequest().authenticated())
                .userDetailsService(customUserDetailsService) // Configuración de servicio de usuarios
                .addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
