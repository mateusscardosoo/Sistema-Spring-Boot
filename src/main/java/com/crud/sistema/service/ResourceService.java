package com.crud.sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.sistema.dto.ResourceDTO;
import com.crud.sistema.entity.ResourceEntity;
import com.crud.sistema.repository.ResourceRepository;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<ResourceDTO> listAll(){
        List<ResourceEntity> resources = resourceRepository.findAll();
        return resources.stream().map(ResourceDTO::new).toList();
    }

    public ResourceDTO listById(Long id){
        return new ResourceDTO(resourceRepository.findById(id).get());
    }


    public void insert(ResourceDTO resource){
        ResourceEntity resourceEntity = new ResourceEntity(resource);
        resourceRepository.save(resourceEntity);
    }

    public ResourceDTO alterate(Long id, ResourceDTO resource){
        ResourceEntity oldResource = resourceRepository.findById(id).get(); 
        ResourceEntity newResource = new ResourceEntity(resource);
        updateData(newResource, oldResource);
        resourceRepository.save(oldResource);
        return new ResourceDTO(oldResource);
    }

     public void updateData(ResourceEntity newResource, ResourceEntity oldResource){
        oldResource.setName(newResource.getName());
        oldResource.setKey(newResource.getKey());
    }





    public void exclude(Long id){
        ResourceEntity resourceEntity = resourceRepository.findById(id).get();
        resourceRepository.delete(resourceEntity);
    }
  
    
}
