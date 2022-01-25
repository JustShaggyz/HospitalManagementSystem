package com.informatics.cscb869hospital.config;

import com.informatics.cscb869hospital.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Bean
    public static PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/hospitals").hasAnyAuthority("ADMIN", "DOCTOR", "PATIENT")
                .antMatchers("/doctors").hasAnyAuthority("ADMIN", "DOCTOR", "PATIENT")
                .antMatchers("/hospitals/create-hospital").hasAnyAuthority("ADMIN")
                .antMatchers("/doctors/create-doctor").hasAnyAuthority("ADMIN")
                .antMatchers("/patients").hasAnyAuthority("ADMIN", "DOCTOR")
                .antMatchers("/patients/create-patient").hasAnyAuthority("ADMIN", "DOCTOR")
                .antMatchers("/records/create-record").hasAnyAuthority("ADMIN", "DOCTOR")
                .antMatchers("/records").hasAnyAuthority("ADMIN", "DOCTOR", "PATIENT")
                .antMatchers("/visits/create-visit").hasAnyAuthority("ADMIN",  "DOCTOR")
                .antMatchers("/visits/search-diagnose").hasAnyAuthority("ADMIN", "DOCTOR")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/unauthorized")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login")
                .permitAll();
    }


}
