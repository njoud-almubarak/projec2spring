package com.example.tuwaiqproject2.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class Cart {
    @NotEmpty(message = "id is required")
    @Size(min = 3,message = "id must be 3 or more character long")
    private Integer ID;
    @NotEmpty(message = "user id is required")
    @Size(min = 3,message = "user id must be 3 or more character long")
    private String Userid;
    private ArrayList <Product> myProduct;

    public Cart(Integer ID, String userid, ArrayList<Product> myProduct) {
        this.ID = ID;
        Userid = userid;
        this.myProduct = new ArrayList<>();
    }

    /* public Cart(Integer ID, String userid, ArrayList<Product> myProduct) {
        this.ID = ID;
        Userid = userid;
        this.myProduct = new ArrayList<>();
    }*/
}
