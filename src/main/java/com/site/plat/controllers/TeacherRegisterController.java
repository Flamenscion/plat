package com.site.plat.controllers;

import com.site.plat.model.User;
import com.site.plat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher-register")
public class TeacherRegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String showTeacherRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Регистрация преподавателя");
        return "teacher-register";
    }

    @PostMapping
    public String registerTeacher(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_TEACHER");
        user.setEnabled(true);
        userService.saveUser(user); // Заменяем registerUser на saveUser
        return "redirect:/login?registered";
    }
}