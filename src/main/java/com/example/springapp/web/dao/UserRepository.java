package com.example.springapp.web.dao;

import com.example.springapp.web.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA Repository for User entity
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    /**
     * Check if user exists by username
     *
     * @param username the username to check
     * @return true if user exists, false otherwise
     */
    default Boolean checkUserExists(String username) {
        return findByUserName(username).isPresent();
    }

    /**
     * Find user by username
     *
     * @param username the username to search for
     * @return Optional containing user if found
     */
    Optional<Users> findByUserName(String username);

    /**
     * Authenticate user with username and password
     *
     * @param username the username
     * @param password the password
     * @return true if authentication successful, false otherwise
     */
    default Boolean login(String username, String password) {
        return findByUserNameAndPassword(username, password).isPresent();
    }

    /**
     * Find user by username and password
     *
     * @param username the username
     * @param password the password
     * @return Optional containing user if found with matching credentials
     */
    Optional<Users> findByUserNameAndPassword(String username, String password);

    /**
     * Get all users
     *
     * @return list of all users
     */
    @Override
    List<Users> findAll();
}