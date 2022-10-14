package com.product.api.controller;

import com.product.api.entity.Category;
import com.product.api.repository.CategoryRepository;

import org.springframework.boot.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;

import org.json.*;
import java.util.Optional;

@RestController
public class CtrlCategory {

    @Autowired
    private CategoryRepository categoryRepository;



    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = "application/json")
    String category() {
        Iterable categories = categoryRepository.findAll();
        JSONArray jsonArray = new JSONArray();
        for (Object object : categories) {
            Category category = Category.class.cast(object);
            if(category.getStatus() == 0)
                continue;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("categoryID", category.getCategoryID());
            jsonObject.put("category", category.getCategory());
            jsonObject.put("status", category.getStatus());
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString();
    }

    @RequestMapping(value = "/category/{categoryID}", method = RequestMethod.GET, produces = "application/json")
    String category(@PathVariable("categoryID") int categoryID){
        Optional<Category> category = categoryRepository.findById(categoryID);
        if(!category.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("categoryID", category.get().getCategoryID());
        jsonObject.put("category", category.get().getCategory());
        jsonObject.put("status", category.get().getStatus());
        return jsonObject.toString();
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST, produces = "application/json")
    String category(@RequestParam(value = "categoryID") int categoryID, @RequestParam(value = "category") String category, @RequestParam(value = "status") int status){
        Optional<Category> categoryOptional = categoryRepository.findById(categoryID);
        if(categoryOptional.isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "category already exists");
        if (status != 0 && status != 1)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status must be 0 or 1");
        Category newCategory = new Category(categoryID, category, status);
        categoryRepository.save(newCategory);
        if(status == 0)
            return "{ \"status\": \"category created\" }";
        return "{ \"status\": \"category activated\" }";
    }

    @RequestMapping(value = "/category", method = RequestMethod.PUT, produces = "application/json")
    String updateCategory(@RequestParam(value = "categoryID") int categoryID, @RequestParam(value = "category") String category, @RequestParam(value = "status") int status){
        Optional<Category> categoryOptional = categoryRepository.findById(categoryID);
        if(!categoryOptional.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category does not exist");
        Category newCategory = new Category(categoryID, category, status);
        categoryRepository.save(newCategory);
        return "{ \"status\": \"category updated\" }";	
    }

    @RequestMapping(value = "/category", method = RequestMethod.DELETE, produces = "application/json")
    String deleteCategory(@RequestParam(value = "categoryID") int categoryID){
        Optional<Category> categoryOptional = categoryRepository.findById(categoryID);
        if(!categoryOptional.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "category does not exist");
        categoryRepository.deleteById(categoryID);
        return "{ \"status\": \"category removed\" }";
    }

}