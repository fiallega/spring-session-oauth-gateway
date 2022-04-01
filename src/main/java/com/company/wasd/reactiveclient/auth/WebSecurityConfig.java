package com.company.wasd.reactiveclient.auth;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.header.ReferrerPolicyServerHttpHeadersWriter;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

        http.csrf().disable();

        http.headers()
                .referrerPolicy(ReferrerPolicyServerHttpHeadersWriter.ReferrerPolicy.NO_REFERRER_WHEN_DOWNGRADE);

        http.authorizeExchange()
                .pathMatchers("/login**","/entries/**").permitAll()
                .anyExchange()
                .authenticated()
                .and()
                .oauth2Login();

        return http.build();
    }

}