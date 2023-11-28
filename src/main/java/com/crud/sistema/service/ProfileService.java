package com.crud.sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.sistema.dto.ProfileDTO;
import com.crud.sistema.entity.ProfileEntity;
import com.crud.sistema.repository.ProfileRepository;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<ProfileDTO> listAll(){
        List<ProfileEntity> profile = profileRepository.findAll();
        return profile.stream().map(ProfileDTO::new).toList();
    }

    public ProfileDTO listById(Long id){
        return new ProfileDTO(profileRepository.findById(id).get());
    }

    public void insert(ProfileDTO profile){
        ProfileEntity profileEntity = new ProfileEntity(profile);
        profileRepository.save(profileEntity);
    }

    public ProfileDTO alterate (Long id, ProfileDTO profile){
        ProfileEntity oldProfile = profileRepository.findById(id).get();
        ProfileEntity newProfile = new ProfileEntity(profile);
        updateData(newProfile, oldProfile);
        profileRepository.save(oldProfile);
        return new ProfileDTO(oldProfile);
    } 

    public void exclude(Long id){
        ProfileEntity profileEntity = profileRepository.findById(id).get();
        profileRepository.delete(profileEntity);
    }


     public void updateData(ProfileEntity newProfile, ProfileEntity oldProfile){
        oldProfile.setDescription(newProfile.getDescription());
     
    }
    
}

