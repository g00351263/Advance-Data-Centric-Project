//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //
// this class is authenticating user and restricting the pages to be viewed before login

package com.sales.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// following is the class allowing password and user name to log in
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("user")).roles("ADMIN"); // user name and password//
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                
                // non restricted pages are below //
                .antMatchers("/resources/**").permitAll() 
                .antMatchers("/login").permitAll()
                .antMatchers("/index").permitAll()
                //.antMatchers("/**").not().hasAuthority("ROLE_CANDIDATE")
                // end restriction of pages //
                //.antMatchers("/**").access("hasAuthority('ROLE_USER')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/index")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/success", true)
                .failureUrl("/loginerror")
                .and()
                .logout()
                .deleteCookies("JSESSIONID");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // encryption to password
    }
}