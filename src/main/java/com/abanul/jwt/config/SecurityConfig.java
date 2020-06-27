package com.abanul.jwt.config;

import com.abanul.jwt.filter.UserFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // only secure API endpoints
        httpSecurity
                .requestMatchers()
                .antMatchers("/api/**");

        // we don't need CSRF because our token is invulnerable
        httpSecurity.csrf().disable();
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.addExposedHeader("Content-Disposition");
        //addAllowedOrigins(config);
        source.registerCorsConfiguration("/**", config);

        httpSecurity.cors().configurationSource(source).and();

        httpSecurity
                .authorizeRequests()
                .antMatchers("/api/**").authenticated();

        // don't create session
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(new UserFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
