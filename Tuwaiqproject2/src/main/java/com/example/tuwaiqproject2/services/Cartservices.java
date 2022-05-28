package com.example.tuwaiqproject2.services;

import com.example.tuwaiqproject2.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class Cartservices {

    private ArrayList<Cart> mycart = new ArrayList<>();
    private final Productservices productservices;
    private final MSservices msservices;
    private final Userservices userservices;
    private Cart currentcart;
    private Product currentproduct;
    private final PHservices phservices;

    public ArrayList<Cart> getcart() {
        return mycart;}


    public boolean addtocart(String uid, String pid) {
        Users uuid = userservices.getUser(uid);
        Product ppid = productservices.getproduct(pid);
        if (uuid.getId().equals(uid) && ppid.getId().equals(pid)) {
            Cart cart2 = getcart(uid);
            cart2.getMyProduct().add(ppid);
            ArrayList<Product> products = new ArrayList<>();
            products.add(productservices.getproduct(pid));
            Cart cart3 = new Cart(mycart.size() - 1, uid, products);
            mycart.add(cart3);
            return true;}
        return false;}

    public boolean removefromcart(String uid, String pid) {
        Users uuid = userservices.getUser(uid);
        Product ppid = productservices.getproduct(pid);
        if (uuid.getId().equals(uid) && ppid.getId().equals(pid)) {
            Cart cart2 = getcart(uid);
            cart2.getMyProduct().remove(ppid);
            return true;}
        return false;}


    public Cart getcart(String uid) {
        for (int i = 0; i < mycart.size(); i++) {
            Cart cart2 = mycart.get(i);
            if (cart2.getUserid().equals(uid))
                return cart2;}
        return null;
    }
public Integer buycart(String uid){
    Cart currentcart=getcart(uid);
    int sumprice=0;
    int balance=0;
    for (int i=0;i<currentcart.getMyProduct().size();i++){
        currentproduct=currentcart.getMyProduct().get(i);
        String p1=currentproduct.getId();
        for (int x = 0; x < msservices.getmstock().size(); x++) {
            MerchantStock currentms=msservices.getmstock().get(x);
            if(p1.equals(currentms.getProductid())){
            Integer stock = currentms.getStock();
            if (stock == 0){
                return -1;}
                currentms.setStock(stock - 1);}}

        int price=currentproduct.getPrice();
         sumprice=+price;
         balance= userservices.getUser(uid).getBalance();
        if(balance<sumprice)
            return 0;
        PurchaseHistory currentph = new PurchaseHistory("123", uid, "pid",price);
        phservices.addhistory(currentph);
    }

       userservices.getUser(uid).setBalance(balance-sumprice);
       return 1;

}
}

