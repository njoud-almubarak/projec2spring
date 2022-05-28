package com.example.tuwaiqproject2.services;

import com.example.tuwaiqproject2.model.Comment;
import com.example.tuwaiqproject2.model.Merchant;
import com.example.tuwaiqproject2.model.Product;
import com.example.tuwaiqproject2.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@RequiredArgsConstructor
public class Productservices {

    private ArrayList<Product> products=new ArrayList<>();
    private final Commentservices commentservices;
  //  private final Userservices userservices;
   // private final Merchantservices merchantservices;
    private Comment currentcomment;

    public ArrayList <Product> getproduct(){
        return products;}
    public boolean addproduct(Product product){
        products.add(product);
    return true;}

    public boolean updateproduct(int index, Product product){
        if (index>products.size()-1){
            return false;
        }
        products.set(index,product);
        return true;}

    public boolean deleteproduct(int index){
        if (index>products.size()-1){
            return false;
        }
        products.remove(index);
        return true;}


    public Product getproduct(String Pid) {
        for (Product product:products) {
            if(product.getId().equals(Pid)){
                return product;
            }
        }
        return null;
    }
    public ArrayList<Product> getpruductwithfive() {
        ArrayList<Product> fiverate = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Product currentproduct = products.get(i);
            for (int x = 0; x < currentproduct.getComments().size(); x++)
                currentcomment = currentproduct.getComments().get(x);
            int rate = currentcomment.getRate();
            if (rate == 5) {
                fiverate.add(currentproduct);
            }
            return fiverate;
        }
        return null;
    }
    public ArrayList<Comment> productrate(String pid){
        for (int i = 0; i < products.size(); i++) {
            Product currentproduct = products.get(i);
            if(currentproduct.getId().equals(pid))
                return currentproduct.getComments();}
            return null;}
    }


