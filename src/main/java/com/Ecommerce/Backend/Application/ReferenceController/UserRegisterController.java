package com.Ecommerce.Backend.Application.ReferenceController;


import com.Ecommerce.Backend.Application.entities.Role;
import com.Ecommerce.Backend.Application.entities.User;
import com.Ecommerce.Backend.Application.repository.RoleRepository;
import com.Ecommerce.Backend.Application.repository.UserRepository;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
public class UserRegisterController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;


    @PostMapping("/register_seller")
    public ResponseEntity<Object> sellerRegistration(@RequestBody User user)
    {    User newUser =new User();

        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setMiddleName(user.getMiddleName());
        newUser.setLastName(user.getLastName());





        Role role= roleRepo.findById(2L).get();

        HashSet<Role>  roles = new HashSet<>();
        HashSet<User> users = new HashSet<>();

        users.add(newUser);
        role.setUsers(users);

        roles.add(role);
        newUser.setRoles(roles);

        User savedUser=userRepo.save(newUser);

        System.out.println(savedUser.getRoles());

        return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, savedUser);
    }
    @PostMapping("/register_customer")
    public ResponseEntity<Object> customerRegistration(@RequestBody User user)
    {    User newUser =new User();

        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setMiddleName(user.getMiddleName());
        newUser.setLastName(user.getLastName());



        Role role= roleRepo.findById(3L).get();

        HashSet<Role>  roles = new HashSet<>();
        HashSet<User> users = new HashSet<>();

        users.add(newUser);
        role.setUsers(users);

        roles.add(role);
        newUser.setRoles(roles);

        User savedUser=userRepo.save(newUser);

        System.out.println(savedUser.getRoles());

        return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, savedUser);
    }


    @PostMapping("/register_both")
    public ResponseEntity<Object> seller_customer_Registration(@RequestBody User user)
    {    User newUser =new User();

        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setMiddleName(user.getMiddleName());
        newUser.setLastName(user.getLastName());



        Role role1= roleRepo.findById(2L).get();
        Role role2= roleRepo.findById(3L).get();

        HashSet<Role>  roles = new HashSet<>();
        HashSet<User> users = new HashSet<>();

        users.add(newUser);
        role1.setUsers(users);
        role2.setUsers(users);

        roles.add(role1);
        roles.add(role2);
        newUser.setRoles(roles);

        User savedUser=userRepo.save(newUser);

        System.out.println(savedUser.getRoles());

        return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, savedUser);
    }


    @PostMapping("/register_admin")
    public ResponseEntity<Object> adminRegistration(@RequestBody User user)
    {    User newUser =new User();

        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setMiddleName(user.getMiddleName());
        newUser.setLastName(user.getLastName());



        Role role= roleRepo.findById(1L).get();

        HashSet<Role>  roles = new HashSet<>();
        HashSet<User> users = new HashSet<>();

        users.add(newUser);
        role.setUsers(users);

        roles.add(role);
        newUser.setRoles(roles);

        User savedUser=userRepo.save(newUser);

        System.out.println(savedUser.getRoles());

        return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, savedUser);
    }
}
