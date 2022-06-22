package com.Ecommerce.Backend.Application.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Product_reviews {
    @Id
    private long id;

    private String reviews;

    private String rating;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name="customerUserId")
    @MapsId
    private Customer customer;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name="productId")
    @MapsId
    private Product product;

    public Product_reviews() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
