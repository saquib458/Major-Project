package com.Ecommerce.Backend.Application.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Cart{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="customer_user_id",referencedColumnName = "user_id")
    private  Customer customer;


    @ManyToOne
    private product_variation product_variation;

    private int quantity;

    private boolean isWishListItem;

}
