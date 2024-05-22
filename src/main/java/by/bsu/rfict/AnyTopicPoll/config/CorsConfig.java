package by.bsu.rfict.AnyTopicPoll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Разрешаем запросы только с http://localhost:3000
        config.addAllowedOrigin("http://localhost:3000");

        // Разрешаем передавать заголовки "Authorization" и "Content-Type"
        config.addAllowedHeader("Authorization");
        config.addAllowedHeader("Content-Type");
        config.addAllowedHeader("Cookie");

        // Разрешаем все HTTP-методы
        config.addAllowedMethod("*");

        // Устанавливаем максимальное время (в секундах) для кэширования предзапроса CORS
        config.setMaxAge(3600L);

        source.registerCorsConfiguration("/**", config);
        config.setAllowCredentials(true);

        return new CorsFilter(source);
    }
}