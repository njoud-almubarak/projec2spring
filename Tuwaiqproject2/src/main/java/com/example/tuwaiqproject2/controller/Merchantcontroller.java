package com.example.tuwaiqproject2.controller;


import com.example.tuwaiqproject2.model.Merchant;
import com.example.tuwaiqproject2.model.apiRessponse;
import com.example.tuwaiqproject2.services.Merchantservices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/merchant")
public class Merchantcontroller {

    private final Merchantservices merchantservices;

    @GetMapping
    public ResponseEntity<ArrayList<Merchant>> getmerchant(){
        return ResponseEntity.status(200).body(merchantservices.getmerchant());}

    @PostMapping
    public ResponseEntity addmerchant(@RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
        if(!( merchantservices.addmerchant(merchant)))
            return ResponseEntity.status(500).body(new apiRessponse("error in server",500));
        return ResponseEntity.status(200).body("merchant is added..");}

    @PutMapping("{index}")
    public ResponseEntity updatemerchanty(@PathVariable Integer index,@RequestBody @Valid Merchant merchant,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
        if(!(merchantservices.updatemerchant(index,merchant)))
            return ResponseEntity.status(401).body("index is error");
        return ResponseEntity.status(200).body("merchant is updated");}

    @DeleteMapping("{index}")
    public ResponseEntity deletemerchant(@PathVariable Integer index){
        if(!(merchantservices.deletetmerchant(index)))
            return ResponseEntity.status(400).body("index is error");
        return ResponseEntity.status(200).body("merchant is deleted");}


}
