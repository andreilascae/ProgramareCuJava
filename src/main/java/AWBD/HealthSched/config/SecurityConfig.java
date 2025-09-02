package AWBD.HealthSched.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // pentru testare/demo; dacă vrei, poți activa CSRF pe POST/PUT/PATCH/DELETE
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        // Swagger & OpenAPI
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/v3/api-docs.yaml").permitAll()

                        // Resurse publice / login
                        .requestMatchers("/login", "/register", "/css/**", "/js/**").permitAll()

                        // API-urile REST — liber pentru testare/prezentare
                        .requestMatchers("/api/**").permitAll()

                        // (Opțional) pagini MVC deschise
                        .requestMatchers("/doctori/**", "/pacienti/**", "/programari/**").permitAll()

                        // orice altă rută: necesită autentificare
                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    // User in-memory pentru login rapid: admin / admin
    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder enc) {
        var admin = org.springframework.security.core.userdetails.User
                .withUsername("admin")
                .password(enc.encode("admin"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService,
                                                            BCryptPasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }
}
