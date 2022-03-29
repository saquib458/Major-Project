package com.Ecommerce.Backend.Application.entities;


import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @Column(name="user_id")
    private long id;

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


}
