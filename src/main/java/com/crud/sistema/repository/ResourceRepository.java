package com.crud.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.sistema.entity.ResourceEntity;


public interface ResourceRepository extends JpaRepository<ResourceEntity, Long>{
    
}
