package com.example.tuwaiqproject2.services;


import com.example.tuwaiqproject2.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MSservices {

    private ArrayList<MerchantStock> mstock = new ArrayList<>();
    private final Userservices userservices;
    private final Merchantservices merchantservices;
    private final Productservices productservices;
    private final PHservices phservices;

    public ArrayList<MerchantStock> getmstock() {
        return mstock;
    }

    public boolean addmstock(MerchantStock merchantStock) {
        mstock.add(merchantStock);
        return true;
    }

    public boolean updatemstock(int index, MerchantStock merchantStock) {
        if (index > mstock.size() - 1) {
            return false;
        }
        mstock.set(index, merchantStock);
        return true;
    }

    public boolean deletetmstock(int index) {
        if (index > mstock.size() - 1) {
            return false;
        }
        mstock.remove(index);
        return true;
    }

    public boolean addmstockfromuser(String uid, String mid, Integer stock) {
        Users user1 = userservices.getUser(uid);
        if (user1 == null)
            return false;
        for (int i = 0; i < mstock.size(); i++) {
            MerchantStock currentms = mstock.get(i);
            if (currentms.getMerchantid().equals(mid))
                currentms.setStock(currentms.getStock() + stock);
        }
        return true;
    }

    public Integer directbuy(String uid, String pid, String mid) {
        Users currentuser = userservices.getUser(uid);
        Product currentproduct = productservices.getproduct(pid);
        if (currentproduct == null || currentuser == null)
            return -1;
        for (int x = 0; x < mstock.size(); x++) {
            MerchantStock currentms = mstock.get(x);
            if (mid.equals(currentms.getMerchantid())) {
                Integer stock = currentms.getStock();
                if (stock == 0)
                    return 0;
                currentms.setStock(stock - 1);
                int price = currentproduct.getPrice();
                int balance = currentuser.getBalance();
                if (price > balance)
                    return 1;
                currentuser.setBalance(price - balance);
                PurchaseHistory currentph = new PurchaseHistory("123", uid, pid, price);
                phservices.addhistory(currentph);

                return 2;
            }
        }
        return 3;
    }
}
