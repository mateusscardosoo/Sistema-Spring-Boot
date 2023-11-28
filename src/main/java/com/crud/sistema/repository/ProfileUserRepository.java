package com.crud.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.sistema.entity.ProfileUserEntity;

public interface ProfileUserRepository extends JpaRepository<ProfileUserEntity, Long> {
    
}
