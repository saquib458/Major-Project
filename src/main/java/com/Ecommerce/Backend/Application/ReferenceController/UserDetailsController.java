package com.Ecommerce.Backend.Application.ReferenceController;



import com.Ecommerce.Backend.Application.entities.Address;
import com.Ecommerce.Backend.Application.entities.Customer;
import com.Ecommerce.Backend.Application.entities.Seller;
import com.Ecommerce.Backend.Application.entities.User;
import com.Ecommerce.Backend.Application.repository.UserRepository;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Objects;

@RestController
public class UserDetailsController {

    @Autowired
    UserRepository userRepo;

    @PostMapping("/seller_details")
    public ResponseEntity<Object> savedSellerDetails(@RequestBody Seller seller)
    {
        User user = userRepo.findById(6L).get();

        Seller newSeller= new Seller();

        newSeller.setGst(seller.getGst());
        newSeller.setCompany_name(seller.getCompany_name());
        newSeller.setCompany_contact(seller.getCompany_contact());

         newSeller.setUser(user);
        user.setSeller(newSeller);

        User savedUser=userRepo.save(user);

        return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, savedUser);


    }

    @PostMapping("/customer_details")
    public ResponseEntity<Object> savedCustomerDetails(@RequestBody Customer customer)
    {
        User user = userRepo.findById(6L).get();

        Customer newCustomer=new Customer();

        newCustomer.setContact(customer.getContact());

        newCustomer.setUser(user);
        user.setCustomer(newCustomer);

        User savedUser=userRepo.save(user);

        return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, savedUser);


    }



    @PostMapping("/user_address")
    public ResponseEntity<Object> savedUserAddress(@RequestBody Address address)
    {
        User user = userRepo.findById(2L).get();

        Address newAddress=new Address();

        HashSet<Address> addresses=new HashSet<>();

        newAddress.setId(address.getId());
        newAddress.setCity(address.getCity());
        newAddress.setState(address.getState());
        newAddress.setCountry(address.getCountry());

        newAddress.setUser(user);
        addresses.add(newAddress);

        user.setAddresses(addresses);

        User savedUser = userRepo.save(user);

        return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, savedUser);



    }

    @GetMapping("/user_details")
    public ResponseEntity<Object> userDetails()
    {
        User user=new User();
        if(!(Objects.isNull(userRepo.findByEmail(("user1@gmail.com"))))) {
            System.out.println("hello");
            user =userRepo.findByEmail("user1@gmail.com");


        }else
        System.out.println(user.getAddresses());
        return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, user);


    }


}
