package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
