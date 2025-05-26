package com.site.plat.controller;

import com.site.plat.model.Grade;
import com.site.plat.model.User;
import com.site.plat.repository.GradeRepository;
import com.site.plat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping("/")
    public String home() {
        return "login"; // Перенаправляем на /profile, который определит роль
    }


    @GetMapping("/teacher-home")
    public String teacherhome() {
        return "teacher-home"; // Перенаправляем на /profile, который определит роль
    }

//    @GetMapping("/")
//    public String home() {
//        return "home"; // Шаблон home.html для корневого маршрута
//    }

    @GetMapping("/home")
    public String home(Authentication authentication, Model model) {
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            User user = userRepository.findByUsername(username).orElseThrow();
            model.addAttribute("username", user.getUsername());
            model.addAttribute("title", "Главная");
        }
        return "home";
    }

//    @GetMapping("/profile")
//    public String profile(Authentication authentication, Model model) {
//        if (authentication != null && authentication.isAuthenticated()) {
//            String username = authentication.getName();
//            User user = userRepository.findByUsername(username).orElseThrow();
//            model.addAttribute("username", user.getUsername());
//            model.addAttribute("user", user);
//            model.addAttribute("title", "Профиль");
//        }
//        return "profile";
//    }

    @GetMapping("/grades")
    public String grades(Authentication authentication, Model model,
                         @RequestParam(value = "year", required = false, defaultValue = "2024-2025") String academicYear) {
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            User user = userRepository.findByUsername(username).orElseThrow();
            List<Grade> grades = gradeRepository.findByUserAndAcademicYear(user, academicYear);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("grades", grades);
            model.addAttribute("selectedYear", academicYear);
            model.addAttribute("title", "Оценки");
        }
        return "grades";
    }
}