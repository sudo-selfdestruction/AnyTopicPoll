package by.bsu.rfict.AnyTopicPoll.config;

import by.bsu.rfict.AnyTopicPoll.service.CustomUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .requestMatchers("/sign-up", "/login", "/swagger-ui/index.html#/").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/polls/create", "polls/{id}").permitAll()
                .requestMatchers("/polls").hasRole("RESPONDENT")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        return http.build();
    }
}