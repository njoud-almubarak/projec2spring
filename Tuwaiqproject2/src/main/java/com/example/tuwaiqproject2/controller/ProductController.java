package com.example.tuwaiqproject2.controller;

import com.example.tuwaiqproject2.model.Product;
import com.example.tuwaiqproject2.model.apiRessponse;
import com.example.tuwaiqproject2.services.Productservices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final Productservices productservices;

    @GetMapping
    public ResponseEntity <ArrayList<Product>> getproduct(){
        return ResponseEntity.status(200).body(productservices.getproduct());}

    @PostMapping
    public ResponseEntity addproduct(@RequestBody @Valid Product product, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
        if(!( productservices.addproduct(product)))
            return ResponseEntity.status(500).body(new apiRessponse("error in server",500));
        return ResponseEntity.status(200).body("product is added..");}

    @PutMapping("{index}")
    public ResponseEntity updateproduct(@PathVariable Integer index,@RequestBody @Valid Product product,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
        if(!(productservices.updateproduct(index,product)))
            return ResponseEntity.status(401).body("index is error");
        return ResponseEntity.status(200).body("product is updated");}

    @DeleteMapping("{index}")
    public ResponseEntity deleteproduct(@PathVariable Integer index){
        if(!(productservices.deleteproduct(index)))
            return ResponseEntity.status(400).body("index is error");
        return ResponseEntity.status(200).body("product is deleted");}

@GetMapping ("/productithfive")
    public ResponseEntity fiverate(){
    if(productservices.getpruductwithfive()==null)
    return ResponseEntity.status(400).body("NO PRODUCT HAS FIVE RATE..");
       return   ResponseEntity.status(200).body( productservices.getpruductwithfive());}
    @GetMapping("{pid}")
    public ResponseEntity productrate(@PathVariable String pid){
       if (productservices.productrate(pid)==null)
           return ResponseEntity.status(400).body("product id is invalid..");
           return ResponseEntity.status(200).body(productservices.productrate(pid));}




}



