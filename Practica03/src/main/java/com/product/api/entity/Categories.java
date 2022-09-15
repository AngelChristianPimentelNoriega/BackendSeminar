package com.product.api.entity;

import org.json.*;

import java.util.ArrayList;

public class Categories {

    private ArrayList<Category> categoryList;
    public Categories(){
        categoryList = new ArrayList<Category>();
    }

    private boolean alreadyExists(int categoryID) {
        for (Category category : this.categoryList) {
            if (category.getCategoryID() == categoryID) {
                return true;
            }
        }
        return false;
    }

    public String createCategory(int categoryID, String category, int status) {
        if (!alreadyExists(categoryID)) {
            this.categoryList.add(new Category(categoryID, category, status));
            return "category created";

        }else{
            return "category already exists";
        }
    }

    public void getCategory(int categoryID) {
        boolean categoryFound = false;
        for (Category category : this.categoryList) {
            if (category.getCategoryID() == categoryID) {
                System.out.println(category.getCategoryID() + " " + category.getCategory());
                categoryFound = true;
            }
        }
        if (!categoryFound) {
            System.out.println("No existe una categoria con el ID ingresado");
        }
    }

    public JSONArray getCategoriesJSON(){
        JSONArray categoriesJSON = new JSONArray();
        if (categoryList.size() == 0) {
            return categoriesJSON;
        }
        for (Category category : categoryList) {
            JSONObject categoryJSON = new JSONObject();
            categoryJSON.put("category_id", category.getCategoryID());
            categoryJSON.put("category", category.getCategory());
            categoriesJSON.put(categoryJSON);
        }
        return categoriesJSON;

        
    }

    public JSONObject getCategoryJSON(int categoryID){
        JSONObject categoryJSON = new JSONObject();
        for (Category category : categoryList) {
            if (category.getCategoryID() == categoryID) {
                categoryJSON.put("category_id", category.getCategoryID());
                categoryJSON.put("category", category.getCategory());
            }
        }
        return categoryJSON;
    }

    public void getCategories(){
        if (categoryList.size() == 0) {
            System.out.println("No existen categorias registradas");
        }
        for (Category category : categoryList) {
            System.out.println(category.getCategoryID() + " " + category.getCategory());
        }
    }

    public String updateCategory(int categoryID, String category, int status) {
        for (Category categoryObj : categoryList) {
            if (categoryObj.getCategoryID() == categoryID) {
                categoryObj.setCategory(category);
                return "category updated";
            }
        }
        return "category not found";
    }
    
    public String deleteCategory(int categoryID) {
        ArrayList<Category> newCategoryList = new ArrayList<Category>();
        String message = "category not found";
        for (Category category : this.categoryList) {
            if (category.getCategoryID() != categoryID) {
                newCategoryList.add(category);
            }
            else {
                message = "category deleted";
            }
        this.categoryList = newCategoryList;
        }
        return message;
    }


    class Category {

        private int categoryID;
        private String category;
        private int status;

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
}