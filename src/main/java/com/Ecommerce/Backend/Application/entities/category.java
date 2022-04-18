package com.Ecommerce.Backend.Application.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class category
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String categoryName;

    @ManyToOne
    @JoinColumn(name="parentCategoryId",referencedColumnName = "id")
    @JsonIgnore
    private category category;

    public category() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public com.Ecommerce.Backend.Application.entities.category getCategory() {
        return category;
    }

    public void setCategory(com.Ecommerce.Backend.Application.entities.category category) {
        this.category = category;
    }
}
