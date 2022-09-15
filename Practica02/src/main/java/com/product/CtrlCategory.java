package com.product;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableAutoConfiguration
public class CtrlCategory {

    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = "application/json")
    String category() {
        Categories categories = new Categories();
        categories.createCategory(1, "Categoria 1");
        categories.createCategory(2, "Categoria 2");
        categories.createCategory(3, "Categoria 3");
        categories.createCategory(4, "Categoria 4");
        categories.createCategory(5, "Categoria 5");
        categories.createCategory(6, "Categoria 6");

        return categories.getCategoriesJSON().toString();


    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CtrlCategory.class, args);
    }

}