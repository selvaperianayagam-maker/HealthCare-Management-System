package com.hospital.healthcare.service;

import com.hospital.healthcare.entity.User;

public interface UserService {
    User registerUser(User user);
    boolean existsByUsername(String username);
}