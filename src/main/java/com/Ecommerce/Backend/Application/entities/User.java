package com.Ecommerce.Backend.Application.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class User {

    @Id
    private long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String password;

    private Boolean is_Deleted;

    private Boolean is_Active;

    private Boolean is_Expired;

    private Boolean is_Locked;

    private int invalid_attempt_count;

    private Date password_update_date;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name ="user_role",joinColumns = @JoinColumn(name ="user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name ="role_id",referencedColumnName = "id"))
    private Set<Role> roles;


    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Seller seller;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Customer customer;

     @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Address> addresses;

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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIs_Deleted() {
        return is_Deleted;
    }

    public void setIs_Deleted(Boolean is_Deleted) {
        this.is_Deleted = is_Deleted;
    }

    public Boolean getIs_Active() {
        return is_Active;
    }

    public void setIs_Active(Boolean is_Active) {
        this.is_Active = is_Active;
    }

    public Boolean getIs_Expired() {
        return is_Expired;
    }

    public void setIs_Expired(Boolean is_Expired) {
        this.is_Expired = is_Expired;
    }

    public Boolean getIs_Locked() {
        return is_Locked;
    }

    public void setIs_Locked(Boolean is_Locked) {
        this.is_Locked = is_Locked;
    }

    public int getInvalid_attempt_count() {
        return invalid_attempt_count;
    }

    public void setInvalid_attempt_count(int invalid_attempt_count) {
        this.invalid_attempt_count = invalid_attempt_count;
    }

    public Date getPassword_update_date() {
        return password_update_date;
    }

    public void setPassword_update_date(Date password_update_date) {
        this.password_update_date = password_update_date;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", is_Deleted=" + is_Deleted +
                ", is_Active=" + is_Active +
                ", is_Expired=" + is_Expired +
                ", is_Locked=" + is_Locked +
                ", invalid_attempt_count=" + invalid_attempt_count +
                ", password_update_date=" + password_update_date +
                ", roles=" + roles +
                ", seller=" + seller +
                ", customer=" + customer +
                ", addresses=" + addresses +
                '}';
    }
}
