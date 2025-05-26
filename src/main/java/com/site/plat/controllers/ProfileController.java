package com.site.plat.controllers;

import com.site.plat.model.User;
import com.site.plat.service.ScheduleService;
import com.site.plat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public String showProfile(Authentication authentication, Model model) {
        String username = authentication.getName();
        model.addAttribute("username", username);
        User user = userService.getUserByUsername(username);
        if (user == null) {
            model.addAttribute("error", "Пользователь не найден");
            return "error";
        }
        model.addAttribute("user", user);
        if ("ROLE_TEACHER".equals(user.getRole())) {
            model.addAttribute("title", "Главная (Преподаватель)");
            model.addAttribute("teacherSchedule", scheduleService.getTeacherSchedule(username));
            return "teacher-profile";
        } else {
            model.addAttribute("title", "Главная (Студент)");
            model.addAttribute("scheduleList", scheduleService.getStudentSchedule(username));
            return "student-profile";
        }
    }
}