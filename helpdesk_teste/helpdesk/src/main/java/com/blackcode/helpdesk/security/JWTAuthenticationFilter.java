package com.blackcode.helpdesk.security;

// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Date;

// import org.springframework.security.authentication.AuthenticationManager;
// import
// org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.AuthenticationException;
// import
// org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// public class JWTAuthenticationFilter extends
// UsernamePasswordAuthenticationFilter {

// private AuthenticationManager authenticationManager;
// private String secret;
// private Long expiration;

// public JWTAuthenticationFilter(AuthenticationManager authenticationManager,
// String secret, Long expiration) {
// this.authenticationManager = authenticationManager;
// this.secret = secret;
// this.expiration = expiration;
// }

// @Override
// public Authentication attemptAuthentication(HttpServletRequest req,
// HttpServletResponse res) throws AuthenticationException {
// try {
// // Adaptar para seu caso de uso específico (ex: pegar usuário e senha do
// corpo da requisição)
// String username = req.getParameter("username");
// String password = req.getParameter("password");

// UsernamePasswordAuthenticationToken authenticationToken = new
// UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());

// return authenticationManager.authenticate(authenticationToken);
// } catch (Exception e) {
// throw new RuntimeException(e);
// }
// }

// @Override
// protected void successfulAuthentication(HttpServletRequest req,
// HttpServletResponse res,
// FilterChain chain,
// Authentication auth) throws IOException, ServletException {
// String username = ((org.springframework.security.core.userdetails.User)
// auth.getPrincipal()).getUsername();
// String token = Jwts.builder()
// .setSubject(username)
// .setExpiration(new Date(System.currentTimeMillis() + expiration))
// .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS512)
// .compact();
// res.addHeader("Authorization", "Bearer " + token);
// }
// }
