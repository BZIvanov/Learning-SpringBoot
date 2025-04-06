package com.example.demo.services;

import com.example.demo.domain.entities.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
}
