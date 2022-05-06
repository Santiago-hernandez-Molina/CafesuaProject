package com.usta.cafesua;

import com.usta.cafesua.models.services.UserServiceImplement;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceImplement userServiceImplement;

    private final BCryptPasswordEncoder bcrypt;

    public SecurityConfig(UserServiceImplement userServiceImplement,BCryptPasswordEncoder bcrypt) {
        this.userServiceImplement = userServiceImplement;
        this.bcrypt=bcrypt;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
        throws Exception{
        auth.userDetailsService(userServiceImplement).passwordEncoder(bcrypt);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity
                .authorizeRequests().antMatchers("/").hasRole("ADMIN")
                .antMatchers("/resources/", "/webjars/","/assets/")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home",true)
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied");
    }

}
