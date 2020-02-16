package com.example.testtask.repositories;
import org.springframework.data.repository.CrudRepository;

import com.example.testtask.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepoList")
public interface UserRepoList extends CrudRepository<User, Long> {
    List<User> findByUsername(String username);
}
