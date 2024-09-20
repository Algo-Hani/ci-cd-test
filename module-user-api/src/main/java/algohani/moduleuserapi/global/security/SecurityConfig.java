package algohani.moduleuserapi.global.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 허용 URL
    private static final String[] PERMIT_ALL = {
        "/api/v1/auth/signup",
        "/api/v1/auth/email-verification/**",
        "/docs/swagger-ui/**",
        "/docs/openapi3.yaml",
        "/v3/api-docs/swagger-config"
    };

    /**
     * SecurityFilterChain 설정
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Basic 인증 비활성화
        http.httpBasic(AbstractHttpConfigurer::disable);

        // CSRF 비활성화
        http.csrf(AbstractHttpConfigurer::disable);

        // FormLogin 비활성화
        http.formLogin(AbstractHttpConfigurer::disable);

        // 세션 비활성화
        http.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // 인증 및 권한 설정
        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
            .requestMatchers(PERMIT_ALL).permitAll()
            .anyRequest().authenticated()
        );

        return http.build();
    }

    /**
     * PasswordEncoder 설정
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
