package com.Ecommerce.Backend.Application.service;

import com.Ecommerce.Backend.Application.dtoClasses.userDto;
import com.Ecommerce.Backend.Application.entities.*;
import com.Ecommerce.Backend.Application.repository.RoleRepository;
import com.Ecommerce.Backend.Application.repository.UserRepository;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;

@Service
public class addUserDetailsService {

    @Autowired
    private emailSenderService senderService;
    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;

    public ResponseEntity<Object> addUserDetails(userDto dto)
    {

        User newUser =new User();


        newUser.setFirstName(dto.getFirstName());
        newUser.setMiddleName(dto.getMiddleName());
        newUser.setLastName(dto.getLastName());
        newUser.setEmail(dto.getEmail());

        newUser.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));

        if(dto.getPhone_number()!=null)
        {
            Role role= roleRepo.findById(3L).get();

            HashSet<Role> roles = new HashSet<>();
            HashSet<User> users = new HashSet<>();

            users.add(newUser);
            role.setUsers(users);

            roles.add(role);
            newUser.setRoles(roles);


            Customer newCustomer=new Customer();

            newCustomer.setContact(dto.getPhone_number());

            newCustomer.setUser(newUser);
            newUser.setCustomer(newCustomer);


            newUser.setIs_Deleted(Boolean.FALSE);
            newUser.setIs_Active(Boolean.FALSE);
            newUser.setIs_Expired(Boolean.FALSE);
            newUser.setIs_Locked(Boolean.FALSE);
            newUser.setIs_Deleted(Boolean.FALSE);
            newUser.setInvalid_attempt_count(0);
            newUser.setPassword_update_date(new Date());



            User savedUser=userRepo.save(newUser);

            senderService.sendMail(newUser.getEmail(),"Registration !!!","welcome to the My Backend Application Service . This is your username "+newUser.getEmail()+" . Your Account is in deActivated state .Please contact to the Admin to activate your Account..  or click on given link to send activation otp .. http://localhost:8080/activation/request/"+newUser.getEmail()+"     ... Warm regards ");

            return ResponseHandler.generateResponse3("Registration done Successfully !!!!!!!", HttpStatus.OK, "null");


        }

        if(dto.getCompany_name()!=null)
        {
            Role role= roleRepo.findById(2L).get();

            HashSet<Role>  roles = new HashSet<>();
            HashSet<User> users = new HashSet<>();

            users.add(newUser);
            role.setUsers(users);

            roles.add(role);
            newUser.setRoles(roles);

            Seller newSeller= new Seller();

            newSeller.setGst(dto.getGst());
            newSeller.setCompany_name(dto.getCompany_name());
            newSeller.setCompany_contact(dto.getCompany_contact());

            newSeller.setUser(newUser);
            newUser.setSeller(newSeller);

            Address newAddress=new Address();

            HashSet<Address> addresses=new HashSet<>();

            newAddress.setCity(dto.getCompany_address().getCity());
            newAddress.setState(dto.getCompany_address().getState());
            newAddress.setCountry(dto.getCompany_address().getCountry());

            newAddress.setUser(newUser);
            addresses.add(newAddress);

            newUser.setAddresses(addresses);



            newUser.setIs_Deleted(Boolean.FALSE);
            newUser.setIs_Active(Boolean.FALSE);
            newUser.setIs_Expired(Boolean.FALSE);
            newUser.setIs_Locked(Boolean.FALSE);
            newUser.setIs_Deleted(Boolean.FALSE);
            newUser.setInvalid_attempt_count(0);
            newUser.setPassword_update_date(new Date());

            User savedUser=userRepo.save(newUser);

            senderService.sendMail(newUser.getEmail(),"Registration !!!","welcome to the My Backend Application Service . This is your username "+newUser.getEmail()+" . Your Account is in Deactivated state .Please contact to the Admin to activate your Account.. Warm regards ");

            return ResponseHandler.generateResponse3("Registration done Successfully !!!!!!!", HttpStatus.OK, "null");




        }


        return null;
    }
}
