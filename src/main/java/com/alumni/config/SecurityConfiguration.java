package com.alumni.config;

import com.alumni.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((request) ->
                        {
                            request.requestMatchers("/api/v1/auth/**").permitAll();
                            request.requestMatchers("/api/v1/products/**").hasAnyAuthority("ADMIN", "USER");
                            request.requestMatchers("/api/v1/categories/**").hasAnyAuthority("ADMIN");
                            request.requestMatchers("/api/v1/address/**").hasAnyAuthority("ADMIN");
                            request.requestMatchers("/api/v1/reviews/**").hasAnyAuthority("ADMIN");
                            request.requestMatchers("/api/v1/users/**").hasAnyAuthority("ADMIN");
                            request.anyRequest().authenticated();
                        }
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
