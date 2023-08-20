package edu.idat.pe.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth ->
                auth.requestMatchers("/home/**", "/login/**", "/password/**", "/usuario/**", "/logout/**", "/css/**", "/js/**", "/imagenes/**").permitAll()
                .anyRequest().authenticated()
            );

            http.formLogin((formLogin) -> formLogin.loginPage("/login").loginProcessingUrl("/process_login").defaultSuccessUrl("/home",true).permitAll());
 
            http.sessionManagement((sessionManagement) ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                    .invalidSessionUrl("/login")
                    .maximumSessions(1)
                    .maxSessionsPreventsLogin(false));
            http.logout((logout) -> logout.logoutSuccessUrl("/login?logout"));
        return http.build();
    }
}
