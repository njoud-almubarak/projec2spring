package com.example.tuwaiqproject2.services;

import com.example.tuwaiqproject2.model.Cart;
import com.example.tuwaiqproject2.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class Commentservices {

    private ArrayList<Comment> comments=new ArrayList<>();
private final PHservices phservices;
    public ArrayList <Comment> getcomments(){
        return comments;}

    public boolean postcomment(String uid,String pid,Comment comment){
        for(int y=0;y<phservices.getphistory().size();y++){
            String uid2=phservices.getphistory().get(y).getUserid();
            String pid2=phservices.getphistory().get(y).getProductid();
            if(uid2.equals(uid)&&pid2.equals(pid)){
                comments.add(comment);
            return true;}}
            return false;
        }
    }

