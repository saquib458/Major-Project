package com.Ecommerce.Backend.Application.validations;


import com.Ecommerce.Backend.Application.dtoClasses.userDto;
import com.Ecommerce.Backend.Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class Validation {
    @Autowired
    UserRepository userRepo;

    public  String matchesPasswordAndConfirmPassword(userDto dto)
    {

        if(!(dto.getPassword().equals(dto.getConfirm_password())))
        return "Password and confirm password does not match";

        return null;
    }

    public String checkMailIsUnique(userDto dto)
    {
        if(!(Objects.isNull(userRepo.findByEmail(dto.getEmail()))))
            return "Please Enter unique Email";

        return null;
    }

        public boolean isValidMobileNo(String str)
        {
            Pattern ptrn = Pattern.compile("(0/91)?[6-9][0-9]{9}");

            Matcher match = ptrn.matcher(str);

            return (match.find() && match.group().equals(str));
        }

        public boolean isValidEmail(String email)
        {
           String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";


            return Pattern.compile(regexPattern)
                    .matcher(email)
                    .matches();
      }

        public boolean isValidPassword(String password)
        {
                String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"                      //+ "(?=(.*[@#$%^&+=]){2})"
                + "(?=\\S+$).{8,20}$";
            return Pattern.compile(regex)
                    .matcher(password)
                    .matches();


        }
}


