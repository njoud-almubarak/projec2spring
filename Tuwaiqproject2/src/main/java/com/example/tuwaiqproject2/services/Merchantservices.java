package com.example.tuwaiqproject2.services;
import com.example.tuwaiqproject2.model.Merchant;
import com.example.tuwaiqproject2.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class Merchantservices {

    private ArrayList <Merchant> merchants=new ArrayList<>();

    public ArrayList <Merchant> getmerchant(){
        return merchants;}
    public boolean addmerchant(Merchant merchant){
        merchants.add(merchant);
        return true;}

    public boolean updatemerchant(int index, Merchant merchant){
        if (index>merchants.size()-1){
            return false;
        }
        merchants.set(index,merchant);
        return true;}

    public boolean deletetmerchant(int index){
        if (index>merchants.size()-1){
            return false;
        }
        merchants.remove(index);
        return true;}

    public Merchant getmerchantbyid(String mid) {
        for (Merchant merchant:merchants) {
            if(merchant.getID().equals(mid)){
                return merchant;
            }
        }
        return null;
    }
}
