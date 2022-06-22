package com.Ecommerce.Backend.Application.entities;


import com.Ecommerce.Backend.Application.dtoClasses.CustomerDetailsDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @Column(name="user_id")
    private long id;


    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name ="user_id")
    private User user;


    public Customer(long id,  String contact) {
        this.id = id;

        this.contact = contact;
    }

    private String contact;

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                '}';
    }

    public CustomerDetailsDto list()
    {
        CustomerDetailsDto customerDetail=new CustomerDetailsDto();

        customerDetail.setId(this.getId());
        customerDetail.setName(this.getUser().getFirstName()+" "+this.getUser().getLastName());
        customerDetail.setEmail(this.getUser().getEmail());
        customerDetail.setIs_Active(this.getUser().getIs_Active());

        return customerDetail;

    }


}
