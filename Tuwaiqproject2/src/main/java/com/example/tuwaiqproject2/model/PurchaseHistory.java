package com.example.tuwaiqproject2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
@Data
@AllArgsConstructor
public class PurchaseHistory {

    @NotEmpty(message = "id is required")
    @Size(min = 3,message = "id must be 3 or more character long")
    private String id;
    @NotEmpty(message = "user id is required")
    @Size(min = 3,message = "user id must be 3 or more character long")
    private String Userid;
    @NotEmpty(message = "product id is required")
    @Size(min = 3,message = "product id must be 3 or more character long")
    private String productid;
    @NotNull(message = "price id is required")
    @Positive(message = "price must be positive number")
     private Integer price;

}
