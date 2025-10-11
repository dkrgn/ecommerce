package com.ecom.repository;

import com.ecom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE id = ?", nativeQuery = true)
    Optional<User> getUserById(int id);

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    Optional<List<User>> getAllUsers();

    @Query(value = "SELECT * FROM users WHERE email = ?", nativeQuery = true)
    Optional<User> getUserByEmail(String email);
}
