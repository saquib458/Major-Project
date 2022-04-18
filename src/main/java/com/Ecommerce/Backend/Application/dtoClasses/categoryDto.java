package com.Ecommerce.Backend.Application.dtoClasses;

public class categoryDto {

    private long parentId;
    private String categoryName;

    private  long categoryId;

    private long metaDataFieldId;

    private String values;

    public categoryDto() {
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getMetaDataFieldId() {
        return metaDataFieldId;
    }

    public void setMetaDataFieldId(long metaDataFieldId) {
        this.metaDataFieldId = metaDataFieldId;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
