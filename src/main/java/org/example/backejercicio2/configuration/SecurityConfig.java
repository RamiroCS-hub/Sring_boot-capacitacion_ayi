package org.example.backejercicio2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails guestUser = User.builder()
                .username("guest")
                .password("{noop}password")
                .roles("GUEST")
                .build();

        UserDetails adminUser = User.builder()
                .username("admin")
                .password("{noop}password")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(guestUser, adminUser);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
            configurer
                    .requestMatchers(HttpMethod.POST, "/productos/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/clientes/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/clientes/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/productos/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/clientes/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/productos/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
