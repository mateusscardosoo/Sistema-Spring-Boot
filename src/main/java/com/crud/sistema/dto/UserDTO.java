package com.crud.sistema.dto;

import org.springframework.beans.BeanUtils;

import com.crud.sistema.entity.UserEntity;

public class UserDTO {

    private long id;
    private String name;
    private String username;
    private String email;
    private String password;


    // Criando um Construtor para converter Entity para DTO, copiando as propriedades iguais de cada um
    public UserDTO(UserEntity usuario){
        BeanUtils.copyProperties(usuario, this);
    }
    
    // Construtor vázio padrão
    public UserDTO(){
        
    }



    //Getters and Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
 
    
}
