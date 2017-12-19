package com.work.service.impl;

import com.work.entity.User;
import com.work.repository.UserRepository;
import com.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Double getBalanceByUser(User user) {
        return userRepository.getBalanceByUser(user);
    }

    @Override
    public Integer updateBalance(Double sum, String userName) {
        return userRepository.setNewBalace(sum, userName);
    }
}
