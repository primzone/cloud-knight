package com.narek.spring.cloud_knight.controller;

import com.narek.spring.cloud_knight.entity.Role;
import com.narek.spring.cloud_knight.entity.User;
import com.narek.spring.cloud_knight.repository.UserRepository;
import com.narek.spring.cloud_knight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public String userList(Model model){

        model.addAttribute("users", userService.findAll());
        return "userlist";
    }


    @GetMapping("{user}")
    public String userEdit(@PathVariable User user, Model model){

        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "useredit";
    }

    @PostMapping()
    public String userSave(@RequestParam String username,
                           @RequestParam Map<String, String> form,
                           @RequestParam("userId") User user){

       userService.saveUser(user, username, form);

        return "redirect:/user";
    }





}
