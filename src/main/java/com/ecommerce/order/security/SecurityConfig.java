package com.ecommerce.order.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    final ProfileAuthenticationEntryPoint authenticationEntryPoint;

    @Value("${app.security.user.name}")
    private String username;

    @Value("${app.security.user.password}")
    private String password;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {

        http.csrf(AbstractHttpConfigurer::disable)
                .headers(httpSecurityHeadersConfigurer -> {
                    httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable);
                })
                .exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint))
                .authorizeHttpRequests(auth -> auth.requestMatchers("/h2-console**").permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                .requestMatchers("/v3/api-docs/**").permitAll()
                .requestMatchers("/swagger-ui.html/**").permitAll()
                .requestMatchers("/login.html/**").permitAll()
                .requestMatchers("/ui/**").permitAll()
                .requestMatchers("/swagger-ui/**").permitAll()
                 .requestMatchers(HttpMethod.POST, "/user/").permitAll()
                .anyRequest().authenticated())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    GrantedAuthoritiesMapper authoritiesMapper()
    {
        SimpleAuthorityMapper mapper = new SimpleAuthorityMapper();
        mapper.setConvertToUpperCase(true);
        mapper.setDefaultAuthority("USER");
        return mapper;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername(username)
                        .password(passwordEncoder().encode(password))
                        .roles("USER")
                        .build()
        );
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        provider.setAuthoritiesMapper(authoritiesMapper());
        return provider;
    }
}
