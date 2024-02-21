package com.example.securityexample.config;

import com.example.securityexample.security.JWTAuthenticationEntryPoint;
import com.example.securityexample.security.JWTAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    private JWTAuthenticationEntryPoint point ;

    @Autowired
    private JWTAuthenticationFilter filter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception {
       //configuration
       http.csrf(AbstractHttpConfigurer::disable)
               .cors(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(auth ->auth.requestMatchers("/home/**").authenticated()
                                        .requestMatchers("/auth/login").permitAll()
                                        .anyRequest().authenticated())
               .exceptionHandling(ex -> ex.authenticationEntryPoint(point))             // exception aae to ye class chale
               .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));           // server pr kuch store nahi karna hai
       http.addFilterBefore(filter , UsernamePasswordAuthenticationFilter.class) ;
       return http.build() ;

   }

}
