package com.product.api.controller;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import org.json.*;

import com.product.api.entity.Categories;


@RestController
@EnableAutoConfiguration
public class CtrlCategory {
    
    Categories categories;

    public CtrlCategory(){
        categories = new Categories();
        categories.createCategory(1, "Abarrotes", 1);
        categories.createCategory(2, "Electronica", 1);
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = "application/json")
    String category() {
        return categories.getCategoriesJSON().toString();
    }

    @RequestMapping(value = "/category/{categoryID}", method = RequestMethod.GET, produces = "application/json")
    String category(@PathVariable("categoryID") int categoryID){
        JSONObject categoryJSON = categories.getCategoryJSON(categoryID);
        if (categoryJSON == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
        return categories.getCategoryJSON(categoryID).toString();
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST, produces = "application/json")
    String category(@RequestParam(value = "categoryID") int categoryID, @RequestParam(value = "category") String category, @RequestParam(value = "status") int status){
        return categories.createCategory(categoryID, category, status);
    }

    @RequestMapping(value = "/category", method = RequestMethod.PUT, produces = "application/json")
    String updateCategory(@RequestParam(value = "categoryID") int categoryID, @RequestParam(value = "category") String category, @RequestParam(value = "status") int status){
        return categories.updateCategory(categoryID, category, status);
    }

    @RequestMapping(value = "/category", method = RequestMethod.DELETE, produces = "application/json")
    String deleteCategory(@RequestParam(value = "categoryID") int categoryID){
        return categories.deleteCategory(categoryID);
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(CtrlCategory.class, args);    
    }

}