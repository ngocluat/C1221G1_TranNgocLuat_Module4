package com.validate_form.service.impl;

import com.validate_form.model.User;
import com.validate_form.repository.IUserRepository;
import com.validate_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iuserRepository;

    @Override
    public List<User> findAll() {
        return iuserRepository.findAll();
    }

    @Override
    public List<User> seachingUser(String name) {
        return null;
    }

    @Override
    public void save(User user) {
        iuserRepository.save(user);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void update(int id, User customer) {

    }

    @Override
    public void remove(int id) {

    }
}
