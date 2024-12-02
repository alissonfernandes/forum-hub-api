package br.com.forumhub.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Classede seguranca a ser carregada pelo spring
@EnableWebSecurity // Customiza configurações de seguranca
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable()) // Desabilita processo de autenticação padão do spring security
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Altera politica de sessão para STATELESS
                .authorizeHttpRequests(req -> {
                    req.requestMatchers(HttpMethod.GET,"/topicos", "/topicos/**").permitAll(); // Requisições publicas
                    req.anyRequest().authenticated(); // Requisiçõs protegidas
                })
                .build();
    }
}
