package com.example.tuwaiqproject2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class Comment {

    @NotEmpty(message = "id is required")
    @Size(min = 3,message = "id must be 3 or more character long")
    private String id;
    @NotEmpty(message = "user id is required")
    @Size(min = 3,message = "user id must be 3 or more character long")
    private String Userid;
    @NotEmpty (message = "message is required")
    @Length (min =6,message = "message must be more than 6 character")
    private String message;
    @NotNull (message = "rate is required")
    @Min(value = 1,message = "rate must be number between 1-5")
    @Max(value = 5, message = "rate must be number between 1-5")
    private Integer rate;
}
