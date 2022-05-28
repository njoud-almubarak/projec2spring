package com.example.tuwaiqproject2.services;

import com.example.tuwaiqproject2.model.Cart;
import com.example.tuwaiqproject2.model.PurchaseHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class PHservices {
    private ArrayList <PurchaseHistory> phistory=new ArrayList<>();
private   PurchaseHistory currentph;
    public ArrayList <PurchaseHistory> getphistory(){
        return phistory;}

    public boolean addhistory(PurchaseHistory PH){

        return phistory.add(PH);
    }

}
