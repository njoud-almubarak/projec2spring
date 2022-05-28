package com.example.tuwaiqproject2.controller;

import com.example.tuwaiqproject2.model.PurchaseHistory;
import com.example.tuwaiqproject2.services.PHservices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("purchasehistory")
public class PHcontroller {

    private final PHservices phservices;

@GetMapping
    public ResponseEntity<ArrayList<PurchaseHistory>> getphestory(){
        return ResponseEntity.status(200).body(phservices.getphistory());
    }
}
