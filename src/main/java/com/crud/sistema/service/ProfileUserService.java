package com.crud.sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.sistema.dto.ProfileUserDTO;
import com.crud.sistema.entity.ProfileUserEntity;
import com.crud.sistema.repository.ProfileUserRepository;

@Service
public class ProfileUserService {

    @Autowired
    private ProfileUserRepository profileUserRepository;

    
    public List<ProfileUserDTO> listAll(){
        List<ProfileUserEntity> profileUser = profileUserRepository.findAll();
        return profileUser.stream().map(ProfileUserDTO::new).toList();
    }

    public ProfileUserDTO listById(Long id){
        return new ProfileUserDTO(profileUserRepository.findById(id).get());
    }


    public void insert(ProfileUserDTO profileUser){
        ProfileUserEntity profileUserEntity = new ProfileUserEntity(profileUser);
        profileUserRepository.save(profileUserEntity);
    }

    public ProfileUserDTO alterate(Long id, ProfileUserDTO profileUser){
        ProfileUserEntity oldProfileUser = profileUserRepository.findById(id).get(); 
        ProfileUserEntity newProfileUser = new ProfileUserEntity(profileUser);
        updateData(newProfileUser, oldProfileUser);
        profileUserRepository.save(oldProfileUser);
        return new ProfileUserDTO(oldProfileUser);
    }

     public void updateData(ProfileUserEntity newProfileUser, ProfileUserEntity oldProfileUser){
        oldProfileUser.setUser(newProfileUser.getUser());
        oldProfileUser.setProfile(newProfileUser.getProfile());
    }





    public void exclude(Long id){
        ProfileUserEntity profileUserEntity = profileUserRepository.findById(id).get();
        profileUserRepository.delete(profileUserEntity);
    }

}
