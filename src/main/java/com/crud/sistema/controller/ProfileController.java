package com.crud.sistema.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.sistema.dto.ProfileDTO;
import org.springframework.http.ResponseEntity;
import com.crud.sistema.service.ProfileService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping(value = "/profile")
@CrossOrigin
public class ProfileController {

    @Autowired
    private ProfileService profileService;

   
    @GetMapping
    public List<ProfileDTO> listAll(){
        return profileService.listAll();
    }

    @PostMapping
    public void insert(@RequestBody ProfileDTO profile, Long id){
        profileService.insert(profile);
    }

    @PutMapping("/{id}")
    public ProfileDTO alterate (@RequestBody ProfileDTO profile, @PathVariable("id") Long id){
        return profileService.alterate(id, profile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclude (@PathVariable("id") Long id){
        profileService.exclude(id);
        return ResponseEntity.ok().build();
    }



 
    
}
