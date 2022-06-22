package com.Ecommerce.Backend.Application.dtoClasses;

import com.Ecommerce.Backend.Application.entities.Address;

import java.util.Set;

public class SellerDetailsDto {


    private long id;

    private String name;

    private String email;

    private Boolean is_active;

    private String company_name;

    private Set<com.Ecommerce.Backend.Application.entities.Address> address;


    private String company_contact;

    public SellerDetailsDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    public String getCompany_contact() {
        return company_contact;
    }

    public void setCompany_contact(String company_contact) {
        this.company_contact = company_contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
