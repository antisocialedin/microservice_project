package com.crud.restapi.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.restapi.model.User;

public interface RepositoryUser extends JpaRepository<User,Long>{
    
}
