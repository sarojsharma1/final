package com.example.backend.security;
import com.example.backend.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    LoginRepository loginRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override

            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                com.example.backend.entity.User user = loginRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username or email:" + username));

                return User.builder().username(username)
                        .password(user.getPassword()).
                        roles(String.valueOf(user.getRole())).build();
            }
        };
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable().and()
                .cors().and().httpBasic()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests().antMatchers("/api/v1/auth/*").permitAll()
                .antMatchers("/h2-console/*").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v1/product/**").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v1/product/supplier/**").hasRole("SUPPLIER")
                .antMatchers(HttpMethod.GET,"/api/v1/orders/customer/*").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/api/v1/orders/supplier/*").hasRole("SUPPLIER")
                .anyRequest().authenticated();
        return http.build();
    }
}
