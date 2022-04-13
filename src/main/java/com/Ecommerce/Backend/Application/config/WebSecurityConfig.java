//package com.Ecommerce.Backend.Application.config;
//
//import com.Ecommerce.Backend.Application.service.UserDetailServiceImpl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
////@Configuration
//public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    UserDetailServiceImpl userDetailService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailService);
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//              http.httpBasic();
//              http.authorizeRequests().mvcMatchers(HttpMethod.GET,"/","/employees","/employees/{id}").hasAnyRole("USER","ADMIN")
//                      .mvcMatchers(HttpMethod.POST,"/employees/add").hasRole("ADMIN")
//                      .and().csrf().disable();
//
//
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder();
//    }
//
//}
