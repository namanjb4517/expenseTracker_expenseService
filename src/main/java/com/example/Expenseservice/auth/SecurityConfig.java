package com.example.Expenseservice.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {



        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/expense/v1/test","/expense/v1/addExpense").permitAll()  // 👈 allow test endpoint
                            .anyRequest().authenticated()
                    ); // 👈 still protect others with JWT
            return http.build();
        }


}
