package com.work.service;


import com.work.entity.User;

public interface UserService {

    User getUserByUserName(String userName);
    Double getBalanceByUser(User user);
    Integer updateBalance(Double sum, String userName);
}
