package com.crud.sistema.entity;

import org.springframework.beans.BeanUtils;

import com.crud.sistema.dto.ProfileUserDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_ProfileUser")
public class ProfileUserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "idProfile")
    private ProfileEntity profile;



    

    public Long getId() {
        return id;
    }





    public void setId(Long id) {
        this.id = id;
    }





    public UserEntity getUser() {
        return user;
    }





    public void setUser(UserEntity user) {
        this.user = user;
    }





    public ProfileEntity getProfile() {
        return profile;
    }





    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }





    public ProfileUserEntity(){

    }

     public ProfileUserEntity(ProfileUserDTO profileUser){
        BeanUtils.copyProperties(profileUser, this);
        if(profileUser != null && profileUser.getUser() != null){
            this.user = new UserEntity(profileUser.getUser());
        }
        if(profileUser != null && profileUser.getProfile() != null){
            this.profile = new ProfileEntity(profileUser.getProfile());
        }

    }
    



    

}
