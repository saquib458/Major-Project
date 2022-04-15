package com.Ecommerce.Backend.Application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


@Configuration
@EnableResourceServer
public class ResourceServiceConfig extends ResourceServerConfigurerAdapter {

    private  static final String RESOURCE_ID="Backend.Application";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().mvcMatchers(HttpMethod.POST,"").hasAnyRole("SELLER","ADMIN","CUSTOMER")
                .mvcMatchers(HttpMethod.GET,"/current/user").hasAnyRole("SELLER","ADMIN","CUSTOMER")
                .mvcMatchers(HttpMethod.GET,"/profile").hasAnyRole("SELLER","CUSTOMER")
                .mvcMatchers(HttpMethod.PATCH,"/update/profile","/update/password").hasAnyRole("SELLER","CUSTOMER")
                .mvcMatchers(HttpMethod.PATCH,"/update/address/{id}").hasRole("SELLER")
                .mvcMatchers(HttpMethod.POST,"/add/address").hasRole("CUSTOMER")
                .mvcMatchers(HttpMethod.GET,"/view/addresses").hasRole("CUSTOMER")
                .mvcMatchers(HttpMethod.DELETE,"/delete/address/{id}").hasRole("CUSTOMER")
                .mvcMatchers(HttpMethod.PATCH,"/admin/**").hasRole("ADMIN").
                mvcMatchers(HttpMethod.GET,"/admin/**").hasRole("ADMIN").
                mvcMatchers(HttpMethod.POST,"/register").permitAll()
                .mvcMatchers("/logout").permitAll()
                .and().csrf().disable().logout().logoutSuccessUrl("/logout/successfully");

    }
}
