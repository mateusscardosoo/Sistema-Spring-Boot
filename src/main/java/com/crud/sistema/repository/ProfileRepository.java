package com.crud.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.sistema.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
    
}
