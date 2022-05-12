package com.validate_form.service;

import com.validate_form.model.User;

import java.util.List;

public interface IUserService {



    List<User> findAll();

    List<User> seachingUser(String name);

    void save(User user);

    User findById(int id);

    void update(int id, User customer);

    void remove(int id);
}
