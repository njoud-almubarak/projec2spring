package com.example.tuwaiqproject2.controller;

import com.example.tuwaiqproject2.model.Category;
import com.example.tuwaiqproject2.model.Product;
import com.example.tuwaiqproject2.model.apiRessponse;
import com.example.tuwaiqproject2.services.Categoryservices;
import com.example.tuwaiqproject2.services.Productservices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/category")
public class Categorycontroller {

    private final Categoryservices categoryservices;

    @GetMapping
    public ResponseEntity<ArrayList<Category>> getcategory(){
        return ResponseEntity.status(200).body(categoryservices.getcategory());}

    @PostMapping
    public ResponseEntity addcategory(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
        if(!( categoryservices.addcategory(category)))
            return ResponseEntity.status(500).body(new apiRessponse("error in server",500));
        return ResponseEntity.status(200).body("category is added..");}

    @PutMapping("{index}")
    public ResponseEntity updatecategory(@PathVariable Integer index,@RequestBody @Valid Category category,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
        if(!(categoryservices.updatecategory(index,category)))
            return ResponseEntity.status(401).body("index is error");
        return ResponseEntity.status(200).body("category is updated");}

    @DeleteMapping("{index}")
    public ResponseEntity deletecategory(@PathVariable Integer index){
        if(!(categoryservices.deletetcategory(index)))
            return ResponseEntity.status(400).body("index is error");
        return ResponseEntity.status(200).body("category is deleted");}

}
