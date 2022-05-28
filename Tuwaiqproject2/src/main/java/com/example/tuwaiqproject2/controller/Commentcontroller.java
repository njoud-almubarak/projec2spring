package com.example.tuwaiqproject2.controller;

import com.example.tuwaiqproject2.model.Cart;
import com.example.tuwaiqproject2.model.Comment;
import com.example.tuwaiqproject2.services.Cartservices;
import com.example.tuwaiqproject2.services.Commentservices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comment")
public class Commentcontroller {


    private final Commentservices commentservices;

    @GetMapping
    public ResponseEntity<ArrayList<Comment>> getcomment() {
        return ResponseEntity.status(200).body(commentservices.getcomments());
    }

    @PostMapping("{uid}/{pid}")
    public ResponseEntity postcomment(@PathVariable String uid, String pid, @RequestBody @Valid Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (!(commentservices.postcomment(uid, pid, comment)))
            return ResponseEntity.status(400).body("the user id or product id is invalid and you must be buy product before");
        return ResponseEntity.status(200).body("comment is posted");}
}

