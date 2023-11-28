package com.crud.sistema.dto;
import org.springframework.beans.BeanUtils;

import com.crud.sistema.entity.ProfileUserEntity;


public class ProfileUserDTO {

    private Long id;
    private UserDTO user;
    private ProfileDTO profile;


    public ProfileUserDTO(){

    }

    public ProfileUserDTO(ProfileUserEntity profileUser){
        BeanUtils.copyProperties(profileUser, this);
        if(profileUser != null && profileUser.getUser() != null){
            this.user = new UserDTO(profileUser.getUser());
        }
        if(profileUser != null && profileUser.getProfile() != null){
            this.profile = new ProfileDTO(profileUser.getProfile());
        }

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public UserDTO getUser() {
        return user;
    }
    public void setUser(UserDTO user) {
        this.user = user;
    }
    public ProfileDTO getProfile() {
        return profile;
    }
    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }


    
    
}
