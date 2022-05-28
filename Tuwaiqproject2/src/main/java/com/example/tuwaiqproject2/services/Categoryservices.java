package com.example.tuwaiqproject2.services;

import com.example.tuwaiqproject2.model.Category;
import com.example.tuwaiqproject2.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class Categoryservices {

    private ArrayList<Category> categories=new ArrayList<>();

    public ArrayList <Category> getcategory(){
        return categories;}
    public boolean addcategory(Category category){
        categories.add(category);
        return true;}

    public boolean updatecategory(int index, Category category){
        if (index>categories.size()-1){
            return false;
        }
        categories.set(index,category);
        return true;}

    public boolean deletetcategory(int index){
        if (index>categories.size()-1){
            return false;
        }
        categories.remove(index);
        return true;}

}
