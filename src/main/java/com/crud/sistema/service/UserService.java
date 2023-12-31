package com.crud.sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.sistema.repository.UserRepository;
import com.crud.sistema.dto.UserDTO;
import com.crud.sistema.entity.UserEntity;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> listAll(){
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }

    public void insert(UserDTO user){
        UserEntity userEntity = new UserEntity(user);
        userRepository.save(userEntity);
    }

    public UserDTO alterate(Long id, UserDTO user){

        UserEntity oldUser = userRepository.findById(id).get(); 
        UserEntity newUser = new UserEntity(user);
        updateData(newUser, oldUser);
        userRepository.save(oldUser);
        return new UserDTO(oldUser);


    }

    public void updateData(UserEntity newUser, UserEntity oldUser){
        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setPassword(newUser.getPassword()); 
        oldUser.setUsername(newUser.getUsername());
        
    }

    public void exclude (Long id){
        UserEntity user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public UserDTO listById(Long id){
        return new UserDTO(userRepository.findById(id).get()); 
    }

}
