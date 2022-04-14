package com.Ecommerce.Backend.Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class orderTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="customer_user_id",referencedColumnName = "user_id",nullable = false)
    private  Customer customer;


    private float amount_paid;
    private Date date_created;
    private String payment_method;

   private String  customer_address_city;

    private String  customer_address_state;

    private String  customer_address_country;

    private String  customer_address_address_line;

    private String  customer_address_zip_code;

    private String  customer_address_label;




    public orderTable() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public float getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(float amount_paid) {
        this.amount_paid = amount_paid;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getCustomer_address_city() {
        return customer_address_city;
    }

    public void setCustomer_address_city(String customer_address_city) {
        this.customer_address_city = customer_address_city;
    }

    public String getCustomer_address_state() {
        return customer_address_state;
    }

    public void setCustomer_address_state(String customer_address_state) {
        this.customer_address_state = customer_address_state;
    }

    public String getCustomer_address_country() {
        return customer_address_country;
    }

    public void setCustomer_address_country(String customer_address_country) {
        this.customer_address_country = customer_address_country;
    }

    public String getCustomer_address_address_line() {
        return customer_address_address_line;
    }

    public void setCustomer_address_address_line(String customer_address_address_line) {
        this.customer_address_address_line = customer_address_address_line;
    }

    public String getCustomer_address_zip_code() {
        return customer_address_zip_code;
    }

    public void setCustomer_address_zip_code(String customer_address_zip_code) {
        this.customer_address_zip_code = customer_address_zip_code;
    }

    public String getCustomer_address_label() {
        return customer_address_label;
    }

    public void setCustomer_address_label(String customer_address_label) {
        this.customer_address_label = customer_address_label;
    }
}
