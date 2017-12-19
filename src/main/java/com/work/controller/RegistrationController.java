package com.work.controller;

import com.work.entity.Role;
import com.work.entity.User;
import com.work.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public void updateBalance(HttpServletResponse response,
                              @RequestParam(name = "password") String password,
                              @RequestParam(name = "username") String username) throws IOException {

        User user = new User();
        user.setRole(Role.USER);
        user.setUsername(username);
        user.setPassword(password);
        user.setRegistration(new Date());
        user.setBalance(0);
        user.setEnabled(true);

        userRepository.save(user);

        response.sendRedirect("/login");
    }




}
