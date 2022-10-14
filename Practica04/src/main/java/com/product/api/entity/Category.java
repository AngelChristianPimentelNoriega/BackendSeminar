package com.product.api.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.persistence.Id;

import org.springframework.lang.NonNull;


@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryID")
    private int categoryID;

    @NonNull
    @Column(name = "category")
    private String category;
    
    @NonNull
    @Column(name = "status")
    @Min(value = 0, message = "Status must be 0 or 1")
    @Max(value = 1, message = "Status must be 0 or 1")
    private int status;

    public Category() {
    }

    public Category(int categoryID, String category, int status) {
        this.categoryID = categoryID;
        this.category = category;
        this.status = status;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
