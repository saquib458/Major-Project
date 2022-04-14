package com.Ecommerce.Backend.Application.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class orderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private orderTable orderTable;

    private int quantity;

    private float price;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name="product_variation_id",referencedColumnName = "id",nullable = false)
    private  product_variation product_variation;

    public orderProduct() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public com.Ecommerce.Backend.Application.entities.orderTable getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(com.Ecommerce.Backend.Application.entities.orderTable orderTable) {
        this.orderTable = orderTable;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public com.Ecommerce.Backend.Application.entities.product_variation getProduct_variation() {
        return product_variation;
    }

    public void setProduct_variation(com.Ecommerce.Backend.Application.entities.product_variation product_variation) {
        this.product_variation = product_variation;
    }
}
