package com.haven.service;

import java.util.List;

import com.haven.dto.UserRegistrationDto;
import com.haven.model.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

    List<User> getAll();
}
