package com.lambdaschool.shelbysprintbookstore.repository;

import com.lambdaschool.shelbysprintbookstore.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}