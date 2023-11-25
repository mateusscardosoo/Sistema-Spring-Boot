package com.crud.sistema.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.sistema.dto.UserDTO;
import com.crud.sistema.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> listAll(){
        return userService.listAll();
    }

    @PostMapping
    public void insert(@RequestBody UserDTO user){
        userService.insert(user);
    }

    @PutMapping
    public UserDTO alterate(@RequestBody UserDTO user){
        return userService.alterate(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclude(@PathVariable("id") Long id){
        userService.exclude(id);
        return ResponseEntity.ok().build();
    }
    
    
}
