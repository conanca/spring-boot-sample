package com.xinhuanet.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by conanca on 16-6-17.
 */
@Document
public class User {
    @Id
    private String id;
    private String name;
    private String password;
    @DBRef
    private List<String> Role;

    public User(String name,String password){
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRole() {
        return Role;
    }

    public void setRole(List<String> role) {
        Role = role;
    }
}
