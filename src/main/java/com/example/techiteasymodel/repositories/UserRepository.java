package com.example.techiteasymodel.repositories;


import com.example.techiteasymodel.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
