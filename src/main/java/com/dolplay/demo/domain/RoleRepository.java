package com.dolplay.demo.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by conanca on 16-9-20.
 */
public interface RoleRepository extends MongoRepository<Role, String> {

    List<User> findByName(String name);
}
