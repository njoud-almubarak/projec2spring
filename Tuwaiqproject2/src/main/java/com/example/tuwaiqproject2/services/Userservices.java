package com.example.tuwaiqproject2.services;

import com.example.tuwaiqproject2.model.Cart;
import com.example.tuwaiqproject2.model.Product;
import com.example.tuwaiqproject2.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class Userservices {
    private ArrayList<Users> users=new ArrayList<>();


    public ArrayList <Users> getusers(){
        return users;}
    public boolean adduser(Users user1){
        users.add(user1);
        return true;}

    public boolean updateuser(int index, Users user1){
        if (index>users.size()-1){
            return false;
        }
        users.set(index,user1);
        return true;}

    public boolean deleteuser(int index){
        if (index>users.size()-1){
            return false;
        }
        users.remove(index);
        return true;}
    public Users getUser(String userid) {
        for (Users user1:users) {
            if(user1.getId().equals(userid)){
                return user1;
            }
        }
        return null;
    }
}
