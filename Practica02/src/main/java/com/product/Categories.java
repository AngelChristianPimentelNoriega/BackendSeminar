package com.product;

import org.json.*;

import java.util.ArrayList;

class Categories {

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

    public void createCategory(int categoryID, String category) {
        if (!alreadyExists(categoryID)) {
            this.categoryList.add(new Category(categoryID, category));
        }else{
            System.out.println("Ya existe una categoria con ese ID");
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

    public void getCategories(){
        if (categoryList.size() == 0) {
            System.out.println("No existen categorias registradas");
        }
        for (Category category : categoryList) {
            System.out.println(category.getCategoryID() + " " + category.getCategory());
        }
    }
    
    public void deleteCategory(int categoryID) {
        ArrayList<Category> newCategoryList = new ArrayList<Category>();
        for (Category category : this.categoryList) {
            if (category.getCategoryID() != categoryID) {
                newCategoryList.add(category);
            }
        this.categoryList = newCategoryList;
        }
    }


    class Category {

        private int categoryID;
        private String category;

        public Category(int categoryID, String category) {
            this.categoryID = categoryID;
            this.category = category;
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

    }
}