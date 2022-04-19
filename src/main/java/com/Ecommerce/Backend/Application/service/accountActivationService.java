package com.Ecommerce.Backend.Application.service;

import com.Ecommerce.Backend.Application.dtoClasses.accountActivationDto;
import com.Ecommerce.Backend.Application.entities.User;
import com.Ecommerce.Backend.Application.entities.accountActivation;
import com.Ecommerce.Backend.Application.repository.UserRepository;
import com.Ecommerce.Backend.Application.repository.accountActivationRepo;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class accountActivationService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    emailSenderService senderService;

    @Autowired
    accountActivationRepo accountActivationRepo;


    public ResponseEntity<Object> accountActivationRequest(String username)
    {
        User user= userRepo.findByEmail(username);

        if(user!=null){

            if(user.getSeller()!=null) {
                return ResponseHandler.generateResponse3("You can't activate the seller account by yourself please contact to admin!!!", HttpStatus.BAD_REQUEST, "null");
            }


            accountActivation accountActivation= accountActivationRepo.findByEmail(username);

            if(accountActivation==null) {
                Random rnd = new Random();
                int number = rnd.nextInt(999999);

                String otp = String.format("%06d", number);

                accountActivation accountActivationUser=new accountActivation();

                accountActivationUser.setEmail(username);
                accountActivationUser.setOtp(otp);

                accountActivationRepo.save(accountActivationUser);



                senderService.sendMail(username,"Account Activation OTP !!!","This is the 6 Digit OTP ( "+otp+" ) for your account activation . .. please click below link to verify the otp .. http://localhost:8080/activate/account" );
                return ResponseHandler.generateResponse3("OTP is send successfully to your registered email  !!!", HttpStatus.OK, "null");

            }
            else
            {
                Random rnd = new Random();
                int number = rnd.nextInt(999999);

                String otp = String.format("%06d", number);

                accountActivation.setOtp(otp);
                accountActivationRepo.save(accountActivation);

                senderService.sendMail(username,"Account Activation OTP !!!","This is the 6 Digit OTP ( "+otp+" ) for your Activation of Account. .. please click below link to verify the otp .. http://localhost:8080/activate/account" );
                return ResponseHandler.generateResponse3("OTP is send successfully to your registered email  !!!", HttpStatus.OK, "null");

            }



        }

        return ResponseHandler.generateResponse3("User not Found !!!", HttpStatus.BAD_REQUEST, "null");

    }


    public ResponseEntity<Object> activateAccount(accountActivationDto dto )
    {
        User user=userRepo.findByEmail(dto.getEmail());
        if(user!=null)
        {
            accountActivation accountActivation= accountActivationRepo.findByEmail(dto.getEmail());

            if(accountActivation==null)
                return ResponseHandler.generateResponse3("No Activation request found by given user name  !!!", HttpStatus.BAD_REQUEST, "null");


            if((dto.getEmail().equals(accountActivation.getEmail())) && (dto.getOtp().equals(accountActivation.getOtp())))
            {
                     user.setIs_Active(Boolean.TRUE);

                    userRepo.save(user);

                    accountActivationRepo.deleteById(accountActivation.getId());

                    senderService.sendMail(dto.getEmail(), " Account Activation !!!", " Dear customer your account Activated successfully !!!");
                    return ResponseHandler.generateResponse3("Account Activated successfully  !!!", HttpStatus.OK, "null");


            }
            return ResponseHandler.generateResponse3("Username and OTP doesn't Matched !!!", HttpStatus.BAD_REQUEST, "null");

        }
        return ResponseHandler.generateResponse3("User not Found !!!", HttpStatus.BAD_REQUEST, "null");


    }


}
