package com.work.repository;

import com.work.entity.Role;
import com.work.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query("update User set balance = balance + :newBalance where username = :userName ")
    Integer setNewBalace(@Param("newBalance") Double newBalance, @Param("userName") String userName);

    @Query("select u from User u where u.username = :userName")
    User findByUserName(@Param("userName") String userName);

    @Query("select u.balance from User u where u = :user")
    Double getBalanceByUser(@Param("user") User user);

    @Query("select u from User u where u.role = :role ")
    List<User> getAllUser(@Param("role") Role role);

}
