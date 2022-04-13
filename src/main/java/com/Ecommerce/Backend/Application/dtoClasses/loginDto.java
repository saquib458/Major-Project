package com.Ecommerce.Backend.Application.dtoClasses;

public class loginDto {

    private  String userName;

    public loginDto() {

    }
    private  String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
