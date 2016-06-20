package com.xinhuanet.demo.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by conanca on 16-6-17.
 */
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByName(String name);
}
