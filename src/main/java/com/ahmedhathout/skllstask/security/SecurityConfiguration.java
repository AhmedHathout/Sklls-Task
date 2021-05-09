package com.ahmedhathout.skllstask.security;

import com.ahmedhathout.skllstask.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableConfigurationProperties
@EnableWebSecurity
@Log4j2
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userRepository);
    }

    @Override
    protected void configure(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .cors() // Enable cors for angular
                .and()
                .authorizeRequests()
                .antMatchers("/api/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutUrl("/api/auth/logout")
                .and()
                .httpBasic(); // Use basic authentication. Not the most secure way but it suffices.
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // This should never be used in production. I used it because we
        // store the username and password manually in the database directly.
        // Had I used BCrypt for example, we would have needed to hash the passwords
        // somehow before inserting them into the database.
        return NoOpPasswordEncoder.getInstance();
    }
}