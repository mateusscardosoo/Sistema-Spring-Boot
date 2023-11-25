package com.crud.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.sistema.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
    
}
