package com.example.testtask.repositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.testtask.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepoList")
public interface UserRepoList extends CrudRepository<User, Long> {
    Page<User> findByUsername(String username, Pageable pageable);

    Page<User> findAll(Pageable pageable);
}
