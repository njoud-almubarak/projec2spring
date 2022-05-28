package com.example.tuwaiqproject2.controller;


import com.example.tuwaiqproject2.model.Users;
import com.example.tuwaiqproject2.model.apiRessponse;
import com.example.tuwaiqproject2.services.Userservices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class Usercontroller {

    private final Userservices userservices;

    @GetMapping
    public ResponseEntity<ArrayList<Users>> getuser() {
        return ResponseEntity.status(200).body(userservices.getusers());
    }

    @PostMapping
    public ResponseEntity adduser(@RequestBody @Valid Users user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
        if(!( userservices.adduser(user)))
            return ResponseEntity.status(500).body(new apiRessponse("error in server",500));
        return ResponseEntity.status(200).body("user is added");
    }

    @PutMapping("{index}")
    public ResponseEntity updateuser(@PathVariable Integer index, @RequestBody @Valid Users user1, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (!(userservices.updateuser(index, user1)))
            return ResponseEntity.status(400).body("index is invalid");
        return ResponseEntity.status(200).body("user is updated");
    }

    @DeleteMapping("{index}")
    public ResponseEntity deleteuser(@PathVariable Integer index) {
        if (!(userservices.deleteuser(index)))
            return ResponseEntity.status(400).body("invalid index");
        return ResponseEntity.status(200).body("user is deleted");
    }
}
