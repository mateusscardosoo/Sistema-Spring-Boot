package com.crud.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.sistema.dto.ProfileUserDTO;
import com.crud.sistema.service.ProfileUserService;

@RestController
@RequestMapping(value = "/profileuser")
@CrossOrigin
public class ProfileUserController {

    @Autowired
    private ProfileUserService profileUserService;

   
    @GetMapping
    public List<ProfileUserDTO> listAll(){
        return profileUserService.listAll();
    }

    @PostMapping
    public void insert(@RequestBody ProfileUserDTO profileUser, Long id){
        profileUserService.insert(profileUser);
    }

    @PutMapping("/{id}")
    public ProfileUserDTO alterate (@RequestBody ProfileUserDTO profileUser, @PathVariable("id") Long id){
        return profileUserService.alterate(id, profileUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclude (@PathVariable("id") Long id){
        profileUserService.exclude(id);
        return ResponseEntity.ok().build();
    }

    
}
