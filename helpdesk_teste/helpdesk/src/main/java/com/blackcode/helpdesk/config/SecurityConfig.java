package com.blackcode.helpdesk.config;

// import java.util.Arrays;
// import java.util.Date;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.env.Environment;
// import org.springframework.security.authentication.AuthenticationManager;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// import com.blackcode.helpdesk.security.JWTAuthenticationFilter;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

// private static final String[] PUBLIC_MATCHERS = { "/h2-console/**" };

// @Autowired
// private Environment env;

// @Autowired
// private UserDetailsService userDetailsService;

// @Value("${jwt.secret}")
// private String secret;

// @Value("${jwt.expiration}")
// private Long expiration;

// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http,
// AuthenticationManager authenticationManager) throws Exception {
// if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
// http.headers(headers -> headers.frameOptions(frameOptions ->
// frameOptions.disable()));
// }
// http
// .cors(cors -> cors.configurationSource(corsConfigurationSource()))
// .csrf(csrf -> csrf.disable())
// .authorizeHttpRequests(authorize -> authorize
// .requestMatchers(PUBLIC_MATCHERS).permitAll()
// .anyRequest().authenticated())
// .sessionManagement(session ->
// session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

// http.addFilter(new JWTAuthenticationFilter(authenticationManager, secret,
// expiration));
// return http.build();
// }

// @Bean
// public AuthenticationManager customAuthenticationManager(HttpSecurity http)
// throws Exception {
// return http.getSharedObject(AuthenticationManagerBuilder.class)
// .userDetailsService(userDetailsService)
// .passwordEncoder(bCryptPasswordEncoder())
// .build();
// }

// @Bean
// public BCryptPasswordEncoder bCryptPasswordEncoder() {
// return new BCryptPasswordEncoder();
// }

// @Bean
// CorsConfigurationSource corsConfigurationSource() {
// CorsConfiguration corsConfiguration = new
// CorsConfiguration().applyPermitDefaultValues();
// corsConfiguration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT",
// "DELETE", "OPTIONS"));
// UrlBasedCorsConfigurationSource source = new
// UrlBasedCorsConfigurationSource();
// source.registerCorsConfiguration("/**", corsConfiguration);
// return source;
// }
// }
