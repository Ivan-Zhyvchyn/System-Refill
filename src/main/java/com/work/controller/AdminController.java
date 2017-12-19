package com.work.controller;

import com.work.entity.Replenishment;
import com.work.entity.Role;
import com.work.entity.User;
import com.work.repository.ReplenishmentRepository;
import com.work.repository.UserRepository;
import netscape.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReplenishmentRepository replenishmentRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/admin/journal")
    public ModelAndView getJournal(ModelAndView modelAndView){
        List<Replenishment> replenishments ;
        replenishments = replenishmentRepository.findAll();

        for(Replenishment r : replenishments)
        r.getUsers().sort((o1, o2) -> o1.getRole().compareTo(o2.getRole()));


        modelAndView.addObject("replenishments",replenishments);
        modelAndView.setViewName("/admin/journal");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/admin/updateBalance")
    public void updateBalance(HttpServletResponse response,
                              @RequestParam(name = "balance") String balance,
                              @RequestParam(name = "user") String username) throws IOException {

        List<User> userAndAdmin = new ArrayList<>();
        userAndAdmin.add(userRepository.findByUserName(username));
        userAndAdmin.add(userRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));

        Replenishment replenishment = new Replenishment();
        replenishment.setDate(new Date());
        replenishment.setSum(Double.parseDouble(balance));
        replenishment.setUsers(userAndAdmin);

        replenishmentRepository.save(replenishment);
        userRepository.setNewBalace(Double.parseDouble(balance),username);
        response.sendRedirect("/admin/index");
    }



    @RequestMapping(method = RequestMethod.GET, path = "/admin/index")
    public ModelAndView getIndex(ModelAndView modelAndView){
        List<User> users;
        users = userRepository.getAllUser(Role.USER);
        modelAndView.addObject("users", users);
        modelAndView.setViewName("/admin/index");

        return modelAndView;
    }
}
