package com.Ecommerce.Backend.Application.dtoClasses;

import com.Ecommerce.Backend.Application.entities.Address;
import com.Ecommerce.Backend.Application.entities.Seller;

import java.util.Set;

public class sellerDto {
    private long id;

    private String firstName;

    private String lastName;

    private Boolean is_Active;

    private String company_name;

    private Set<Address> address;


    private String company_contact;

    public sellerDto() {
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_contact() {
        return company_contact;
    }

    public void setCompany_contact(String company_contact) {
        this.company_contact = company_contact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getIs_Active() {
        return is_Active;
    }

    public void setIs_Active(Boolean is_Active) {
        this.is_Active = is_Active;
    }



    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }
}
