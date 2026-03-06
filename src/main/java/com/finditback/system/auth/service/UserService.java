package com.finditback.system.auth.service;

import com.finditback.system.auth.Decorator.*;
import com.finditback.system.auth.Model.User;
import jakarta.mail.MessagingException;
import org.springframework.data.domain.Page;

public interface UserService {
    AuthResponse createUser(RegisterRequest request) throws MessagingException;

    AuthResponse login(LoginRequest request);

    User getUserById(String id);

    Page<User> getAllUsers(int page, int size);

    AuthResponse updateUser(String id, UserUpdateRequest request);

    void deleteUser(String id);
}
