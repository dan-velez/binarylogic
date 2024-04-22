package com.blit.repository;

import org.springframework.data.repository.CrudRepository;

import com.blit.entity.Owner;

public interface OwnerRepository extends CrudRepository <Owner, Long> {
    
}
