package io.bootify.l15_minor_project_02.config;

import io.bootify.l15_minor_project_02.service.AppUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AppUserDetailService appUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("shashi").password("$2a$10$sPheJfJg74M/G3APrHCcuu0TcRmFHslwUg12Jh0p1YVcEuE2cZb6.").authorities("user")
//                .and().withUser("ravi").password("123").authorities("admin");
        auth.userDetailsService(appUserDetailService);
    }


    @Bean
    public PasswordEncoder getPasswordEncoder(){
        // return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("1234"));
        //$2a$10$qyCuKDoGebf0a6bN90cNdealW08J311CcnG9h5R9LYo/aSckisSAG
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests().antMatchers("/api/admin/*").hasAuthority("admin")
                .antMatchers("/api/resident/*").hasAnyAuthority("user")
                .antMatchers("/api/gatekeeper/*").hasAnyAuthority("gatekeeper");
        httpSecurity.formLogin();
        httpSecurity.httpBasic();
        httpSecurity.csrf().disable();
    }

}

