package com.narek.spring.cloud_knight.controller;

import com.narek.spring.cloud_knight.entity.Role;
import com.narek.spring.cloud_knight.entity.User;
import com.narek.spring.cloud_knight.repository.UserRepository;
import com.narek.spring.cloud_knight.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MonsterService monsterService;


    @GetMapping("/registration")
    public String registration(){

        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model){

        //if (user.getPassword() != null)

        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute(user);
            return "registration";
        }


        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null){
            model.addAttribute("message", "Такой пользователь уже существует!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        monsterService.createNewMonsterForUser(user);

        model.addAttribute("message", "Аккаунт успешно создан");
        return "redirect:/login";
    }


}
