package com.example.testtask.repositories;
import org.springframework.data.repository.CrudRepository;

import com.example.testtask.models.User;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepositories extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
