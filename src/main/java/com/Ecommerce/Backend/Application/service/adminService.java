package com.Ecommerce.Backend.Application.service;


import com.Ecommerce.Backend.Application.entities.User;
import com.Ecommerce.Backend.Application.repository.UserRepository;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class adminService {
    @Autowired
    private emailSenderService senderService;
    @Autowired
    UserRepository userRepo;


    public ResponseEntity<Object> activateUser(String username)
    {
        User user=userRepo.findByEmail(username);

        if(user!=null){

            if(user.getIs_Active())
                return ResponseHandler.generateResponse3("User is Already Activated !!!!", HttpStatus.OK, "null");
            user.setIs_Active(Boolean.TRUE);
            userRepo.save(user);

            senderService.sendMail(username,"Activation of Account !!!","Your Account is Activated Successfully please Login to use the Application services");

            return ResponseHandler.generateResponse3("User Activated Successfully !!!!", HttpStatus.OK, "null");


        }
        else
            return ResponseHandler.generateResponse3("User Not Found by given Username !!!! ", HttpStatus.OK, "null");

    }

    public ResponseEntity<Object> deActivateUser(String username)
    {
        if(username.equals("saquibmohd458@gmail.com"))
            return ResponseHandler.generateResponse3("Yoy Don't Deactivate the Main admin user !!!! ", HttpStatus.OK, "null");

        User user=userRepo.findByEmail(username);

        if(user!=null){

            if(!user.getIs_Active())
                return ResponseHandler.generateResponse3("User is Already deActivated !!!!", HttpStatus.OK, "null");
            user.setIs_Active(Boolean.FALSE);
            userRepo.save(user);
            senderService.sendMail(username,"deActivation of Account !!!","Your Account is deActivated for some reason please contact to admin to reActivate your account");

            return ResponseHandler.generateResponse3("User deActivated Successfully !!!!", HttpStatus.OK, "null");


        }
        else
            return ResponseHandler.generateResponse3("User Not Found by given Username !!!! ", HttpStatus.OK, "null");

    }

}
