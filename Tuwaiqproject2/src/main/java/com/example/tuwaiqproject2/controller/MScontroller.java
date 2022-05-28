package com.example.tuwaiqproject2.controller;


import com.example.tuwaiqproject2.model.MerchantStock;
import com.example.tuwaiqproject2.model.apiRessponse;
import com.example.tuwaiqproject2.services.MSservices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/mechantstock")
public class MScontroller {

    private final MSservices msservices;


    @GetMapping
    public ResponseEntity<ArrayList<MerchantStock>> getmerchantstock(){
        return ResponseEntity.status(200).body(msservices.getmstock());}

    @PostMapping
    public ResponseEntity addmerchantstock(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
        if(!( msservices.addmstock(merchantStock)))
            return ResponseEntity.status(500).body(new apiRessponse("error in server",500));
        return ResponseEntity.status(200).body("MerchantStock is added..");}

    @PutMapping("{index}")
    public ResponseEntity updatemerchantstock(@PathVariable Integer index,@RequestBody @Valid MerchantStock merchantStock,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
        if(!(msservices.updatemstock(index,merchantStock)))
            return ResponseEntity.status(401).body("index is error");
        return ResponseEntity.status(200).body("MerchantStock is updated");}

    @DeleteMapping("{index}")
    public ResponseEntity deletemerchant(@PathVariable Integer index){
        if(!(msservices.deletetmstock(index)))
            return ResponseEntity.status(400).body("index is error");
        return ResponseEntity.status(200).body("MerchantStock is deleted");}

    @PostMapping("/{uid}/{mid}/{stock}")
    public ResponseEntity addproducttoMS(@PathVariable String uid,String mid,Integer stock){
       boolean result= msservices.addmstockfromuser(uid,mid,stock);
        if(!(result))
        return ResponseEntity.status(400).body("user id or merchant id is error");
        return ResponseEntity.status(200).body("product is added");}

    @PutMapping("/{uid}/{pid}/{mid}")
    public ResponseEntity directbuy(@PathVariable String uid, String pid,String mid){
        Integer result= msservices.directbuy(uid,pid,mid);
        switch (result){
            case -1:
                return ResponseEntity.status(400).body("bad request -user id or product id- is invalid");
            case 0:
                return ResponseEntity.status(400).body("sorry ! the product is finished");
            case 1:
                return ResponseEntity.status(400).body("sorry ! your balance not enough ");
            case 2:
                return ResponseEntity.status(200).body("The user : " +
            " "+uid+" Bought the book : "+ pid);
            default:
                return ResponseEntity.status(500).body("error in server");
        }

    }


}
