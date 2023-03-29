package com.example.userservice.database;

import com.example.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUser extends JpaRepository<User, Long> {

}
