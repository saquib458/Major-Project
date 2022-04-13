package com.Ecommerce.Backend.Application.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private  String name;

    private String description;

    private Boolean is_cancellable;

    private Boolean is_returnable;

    private String brand;

    private Boolean is_active;

    private Boolean is_deleted;

    @OneToOne
    @JoinColumn(name = "categoryId",referencedColumnName = "id")
    private category category;

    @OneToMany
    @JoinColumn(name="productId",referencedColumnName = "id")
    private Set<product_variation> productVariations;


    public product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIs_cancellable() {
        return is_cancellable;
    }

    public void setIs_cancellable(Boolean is_cancellable) {
        this.is_cancellable = is_cancellable;
    }

    public Boolean getIs_returnable() {
        return is_returnable;
    }

    public void setIs_returnable(Boolean is_returnable) {
        this.is_returnable = is_returnable;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public com.Ecommerce.Backend.Application.entities.category getCategory() {
        return category;
    }

    public void setCategory(com.Ecommerce.Backend.Application.entities.category category) {
        this.category = category;
    }

    public Set<product_variation> getProductVariations() {
        return productVariations;
    }

    public void setProductVariations(Set<product_variation> productVariations) {
        this.productVariations = productVariations;
    }
}
