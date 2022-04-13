package com.Ecommerce.Backend.Application.service;

import com.Ecommerce.Backend.Application.entities.User;
import com.Ecommerce.Backend.Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=repository.findByEmail(username);
        System.out.println(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("user not found");
        }
     else

         return  user;

    }
}
