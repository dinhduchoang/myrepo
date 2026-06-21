package com.hoangd.identity_service.repository;


import com.hoangd.identity_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);
    boolean existsById(String userId);
    Optional<User> findByUsername(String username);
}
