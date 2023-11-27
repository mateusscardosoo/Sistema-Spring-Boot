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

import com.crud.sistema.dto.ResourceDTO;
import com.crud.sistema.service.ResourceService;



@RestController
@RequestMapping(value = "/resource")
@CrossOrigin
public class ResourceController {

    @Autowired
    private ResourceService resourceService;


    @GetMapping
    public List<ResourceDTO> listAll(){
        return resourceService.listAll();
    }

 
    @PostMapping
    public void insert(@RequestBody ResourceDTO resouce){
        resourceService.insert(resouce);
    }

    @PutMapping("/{id}")
    public ResourceDTO alterate(@RequestBody ResourceDTO resource, @PathVariable("id") Long id){
        return resourceService.alterate(id, resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclude(@PathVariable("id") Long id){
    resourceService.exclude(id);
    return ResponseEntity.ok().build();
   
    }


    

    
}
