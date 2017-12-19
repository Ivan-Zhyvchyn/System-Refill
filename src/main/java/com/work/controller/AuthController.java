package com.work.controller;

import com.work.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public void home(HttpServletResponse response) throws IOException {


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().iterator().next().getAuthority().equals("USER")) {
            response.sendRedirect("/user/index");

        } else {
            response.sendRedirect("/admin/index");
        }

    }


    @RequestMapping(method = RequestMethod.GET, path = "/register")
    public String registration(Model model) {
        return "register";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String login(Model model) {
        return "login";
    }


}
