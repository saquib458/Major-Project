package com.Ecommerce.Backend.Application.dtoClasses;

public class accountActivationDto {


    private String email;
    private String otp;


    public accountActivationDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
