package com.example.tuwaiqproject2.model;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class Merchant {
    @NotEmpty(message = "id is required")
    @Size(min = 3,message = "id must be 3 or more character long")
    private String ID;
    @NotEmpty (message = "name is required")
    @Size(min = 3,message = "name must be 3 or more character long")
    private String name;
}
