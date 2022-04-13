package com.Ecommerce.Backend.Application.event;

import com.Ecommerce.Backend.Application.entities.Role;
import com.Ecommerce.Backend.Application.entities.User;
import com.Ecommerce.Backend.Application.repository.RoleRepository;
import com.Ecommerce.Backend.Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;


    public void createRoles()
    {


    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Role role1=new Role();
        Role role2 = new Role();
        Role role3 =new Role();

        role1.setId(1l);
        role1.setAuthority("ROLE_ADMIN");

        role2.setId(2l);
        role2.setAuthority("ROLE_SELLER");

        role3.setId(3l);
        role3.setAuthority("ROLE_CUSTOMER");

        roleRepo.save(role1);
        roleRepo.save(role2);
        roleRepo.save(role3);



        if(Objects.isNull(userRepo.findByEmail("saquibmohd458@gmail.com")))
        {
            Role role = roleRepo.findById(1l).get();
            Set<User> users = new HashSet<>();

            User user = new User();
            user.setId(1l);
            user.setEmail("saquibmohd458@gmail.com");
            user.setFirstName("Mohd");
            user.setMiddleName("Saquib");
            user.setLastName("Ansari");
            user.setPassword(new BCryptPasswordEncoder().encode("S@quib1411"));



            users.add(user);
             role.setUsers(users);

             Set<Role> roles = new HashSet<>();

             roles.add(role);
             user.setRoles(roles);


           user.setIs_Deleted(Boolean.FALSE);
           user.setIs_Active(Boolean.TRUE);
           user.setIs_Expired(Boolean.FALSE);
           user.setIs_Locked(Boolean.FALSE);
           user.setIs_Deleted(Boolean.FALSE);
           user.setInvalid_attempt_count(0);
           user.setPassword_update_date(new Date());

            System.out.println("hello");
            userRepo.save(user);
  }

    }
}
