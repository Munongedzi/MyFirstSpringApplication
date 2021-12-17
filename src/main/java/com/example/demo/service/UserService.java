package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    public User create(User user);

    public User read(Long id);

    public User update(Long userId, User user);
}
