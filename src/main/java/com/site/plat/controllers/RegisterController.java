package com.site.plat.controllers;

import com.site.plat.dto.UserRegistrationDTO;
import com.site.plat.model.User;
import com.site.plat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserRegistrationDTO userDTO, Model model) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setMiddleName(userDTO.getMiddleName());
        user.setLastName(userDTO.getLastName());
        user.setGroupName(userDTO.getGroupName());
        user.setEnabled(true);
        user.setRole("ROLE_STUDENT");

        MultipartFile profilePhoto = userDTO.getProfilePhoto();
        if (profilePhoto != null && !profilePhoto.isEmpty()) {
            try {
                String uploadDir = System.getProperty("user.dir") + "/static.uploads/";
                File uploadDirFile = new File(uploadDir);
                if (!uploadDirFile.exists()) {
                    uploadDirFile.mkdirs();
                }

                String fileName = UUID.randomUUID() + "_" + profilePhoto.getOriginalFilename();
                File file = new File(uploadDir + fileName);
                System.out.println("Попытка сохранить файл в: " + file.getAbsolutePath());
                profilePhoto.transferTo(file);
                System.out.println("Файл успешно сохранён: " + file.getAbsolutePath());

                user.setProfilePhoto("/static.uploads/" + fileName);
            } catch (IOException e) {
                System.err.println("Ошибка при сохранении файла: " + e.getMessage());
                model.addAttribute("error", "Ошибка при загрузке файла: " + e.getMessage());
                return "register"; // Возвращаем на страницу регистрации с ошибкой
            }
        } else {
            user.setProfilePhoto(null);
        }

        try {
            userService.saveUser(user);
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка при регистрации: " + e.getMessage());
            return "register";
        }

        return "redirect:/login";
    }
}