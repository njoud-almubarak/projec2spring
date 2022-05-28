package com.example.tuwaiqproject2.controller;

import com.example.tuwaiqproject2.model.Cart;
import com.example.tuwaiqproject2.services.Cartservices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cart")

public class Cartcontroller {
    private final Cartservices cartservices;

    @GetMapping
    public ResponseEntity<ArrayList<Cart>> getcart() {
        return ResponseEntity.status(200).body(cartservices.getcart());}

    @GetMapping("{uid}")
    public ResponseEntity getcartbyuserid(@PathVariable String uid){
        if (cartservices.getcart()==null)
            return ResponseEntity.status(400).body("theuser id is invalid");
        return ResponseEntity.status(200).body(cartservices.getcart(uid));
    }

    @PostMapping("{uid}/{pid}")
    public ResponseEntity addtocart(@PathVariable String uid, String pid) {

        if (!(cartservices.addtocart(uid, pid)))
            return ResponseEntity.status(400).body("user id or product id invalid");
        return ResponseEntity.status(200).body("the product is added to cart ");
    }
    @PutMapping("{uid}/{pid}")
    public ResponseEntity removeproductfromcart(@PathVariable String uid,String pid){
        if (!(cartservices.removefromcart(uid, pid)))
            return ResponseEntity.status(400).body("user id or product id invalid");
        return ResponseEntity.status(200).body("the product is deleted to cart ");
    }
    @PutMapping("/buycart/{uid}")
    public ResponseEntity buycart(@PathVariable String uid){
       int result= cartservices.buycart(uid);
       switch (result){

           case -1:
               return ResponseEntity.status(400).body("sorry ! one of the product is finished");
           case 0:
               return ResponseEntity.status(400).body("sorry ! your balance not enough");
           case 1:
               return ResponseEntity.status(200).body("thank you "+
                       " "+uid+" purchase ok..");
           default:
               return ResponseEntity.status(500).body("error in server");


       }
    }
}
