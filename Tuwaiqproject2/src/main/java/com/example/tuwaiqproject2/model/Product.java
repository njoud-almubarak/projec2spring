package com.example.tuwaiqproject2.model;

import lombok.Data;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class Product {

    @NotEmpty (message = "id is required")
    @Size(min = 3,message = "id must be 3 or more character long")
    private String id;

    @NotEmpty (message = "name is required")
    @Size(min = 3,message = "name must be 3 or more character long")
    private String name;

    @NotNull(message = "price is required")
    @Positive (message = "price must be positive number ..")
    private Integer price;

    @NotEmpty (message = "categoryID is required")
    @Size(min = 3,message = "categoryID must be 3 or more character long")
    private String categoryID;

    private ArrayList<Comment> comments;


    public Product(String id, String name, Integer price, String categoryID, ArrayList<Comment> comments) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryID = categoryID;
        this.comments = new ArrayList<>();
    }
}
