package com.Ecommerce.Backend.Application.entities;


import javax.persistence.*;

@Entity
public class categoryMetadataFieldValues {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String value;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categoryId",referencedColumnName = "id",nullable = false)
    private category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="categoryMetadataId",referencedColumnName = "id",nullable = false)
    private categoryMetadataField categoryMetadataField;

    public categoryMetadataFieldValues() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public com.Ecommerce.Backend.Application.entities.category getCategory() {
        return category;
    }

    public void setCategory(com.Ecommerce.Backend.Application.entities.category category) {
        this.category = category;
    }

    public com.Ecommerce.Backend.Application.entities.categoryMetadataField getCategoryMetadataField() {
        return categoryMetadataField;
    }

    public void setCategoryMetadataField(com.Ecommerce.Backend.Application.entities.categoryMetadataField categoryMetadataField) {
        this.categoryMetadataField = categoryMetadataField;
    }
}
