package com.Ecommerce.Backend.Application.service;


import com.Ecommerce.Backend.Application.dtoClasses.ForgotPasswordDto;
import com.Ecommerce.Backend.Application.entities.User;
import com.Ecommerce.Backend.Application.repository.UserRepository;
import com.Ecommerce.Backend.Application.repository.ForgotPasswordRepo;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import com.Ecommerce.Backend.Application.validations.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.Ecommerce.Backend.Application.entities.ForgotPassword;
import java.util.Random;

@Service
public class ForgotPasswordService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    EmailSenderService senderService;

    @Autowired
    ForgotPasswordRepo forgotPasswordRepo;

    @Autowired
    Validation validation;


    public ResponseEntity<Object> forgotPasswordM(String username)
    {
          User user= userRepo.findByEmail(username);

          if(user!=null){

              ForgotPassword forgotPasswordUser=forgotPasswordRepo.findByEmail(username);

              if(forgotPasswordUser==null) {
                  Random rnd = new Random();
                  int number = rnd.nextInt(999999);

                  String otp = String.format("%06d", number);

                  ForgotPassword newForgotPasswordUser =new ForgotPassword();

                  newForgotPasswordUser.setEmail(username);
                  newForgotPasswordUser.setOtp(otp);

                  forgotPasswordRepo.save(newForgotPasswordUser);

                  senderService.sendMail(username,"Forgot Password OTP !!!","This is the 6 Digit OTP ( "+otp+" ) for your resetting the password . please click below link to verify the otp .. http://localhost:8080/reset/password" );
                  return ResponseHandler.generateResponse3("OTP is send successfully to your registered email  !!!", HttpStatus.OK, "null");

              }
              else
              {
                  Random rnd = new Random();
                  int number = rnd.nextInt(999999);

                  String otp = String.format("%06d", number);

                  forgotPasswordUser.setOtp(otp);
                  forgotPasswordRepo.save(forgotPasswordUser);

                  senderService.sendMail(username,"Forgot Password OTP !!!","This is the 6 Digit OTP ( "+otp+" ) for your resetting the password . please click below link to verify the otp .. http://localhost:8080/reset/password" );
                  return ResponseHandler.generateResponse3("OTP is send successfully to your registered email  !!!", HttpStatus.OK, "null");

              }



          }

           return ResponseHandler.generateResponse3("User not Found !!!", HttpStatus.BAD_REQUEST, "null");

    }


   public ResponseEntity<Object> resetPassword(ForgotPasswordDto dto )
    {
        User user=userRepo.findByEmail(dto.getEmail());
        if(user!=null)
        {
            ForgotPassword newForgotPasswordUser =forgotPasswordRepo.findByEmail(dto.getEmail());
            if(newForgotPasswordUser==null)
                return ResponseHandler.generateResponse3("No forgot Password request found by given user name  !!!", HttpStatus.BAD_REQUEST, "null");


            if((dto.getEmail().equals(newForgotPasswordUser.getEmail())) && (dto.getOtp().equals(newForgotPasswordUser.getOtp())))
            {

                if(!(dto.getPassword().equals(dto.getConfirm_password()))) {
                    return ResponseHandler.generateResponse3("Password and Confirm Password doesn't match !!!", HttpStatus.BAD_REQUEST, "null");
                }

                if(validation.isValidPassword(dto.getPassword())) {
                    user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));

                    userRepo.save(user);

                    forgotPasswordRepo.deleteById(newForgotPasswordUser.getId());

                    senderService.sendMail(dto.getEmail(), " Password updated !!!", " Dear customer your password updated successfully !!!");
                    return ResponseHandler.generateResponse3("Password Reset successfully  !!!", HttpStatus.OK, "null");

                }

                return ResponseHandler.generateResponse3("Password should contain atLeast 8 characters and  '1 uppercase' '1 lowercase'  ' 1 special character ' and ' 1 numeric digit'  !!!", HttpStatus.BAD_REQUEST, "null");


            }
            return ResponseHandler.generateResponse3("Username and OTP doesn't Matched !!!", HttpStatus.BAD_REQUEST, "null");

        }
        return ResponseHandler.generateResponse3("User not Found !!!", HttpStatus.BAD_REQUEST, "null");


    }


}



