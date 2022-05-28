package com.example.tuwaiqproject2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotEmpty(message = "id is required")
    @Size(min = 3,message = "id must be 3 or more character long")
    private String id;
    @NotEmpty(message = "productid is required")
    @Size(min = 3,message = "productid must be 3 or more character long")
    private String productid;
    @NotEmpty(message = "merchantid is required")
    @Size(min = 3,message = "merchantid must be 3 or more character long")
    private String merchantid;
    @NotNull(message = "id is required")
    @Min(value = 10,message = "id must be 10 or more ")
    private Integer stock;

}
