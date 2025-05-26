package com.site.plat.service;

import com.site.plat.model.Schedule;
import com.site.plat.model.User;
import com.site.plat.repository.ScheduleRepository;
import com.site.plat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private UserRepository userRepository;

    // Получение расписания для преподавателя по его username
    public List<Schedule> getTeacherSchedule(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с username " + username + " не найден"));
        String teacherName = user.getFirstName() + " " +
                (user.getMiddleName() != null ? user.getMiddleName() + " " : "") +
                user.getLastName();
        return scheduleRepository.findByTeacher(teacherName);
    }

    // Получение расписания для студента по его groupName
    public List<Schedule> getStudentSchedule(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с username " + username + " не найден"));
        String groupName = user.getGroupName();
        return scheduleRepository.findByGroupName(groupName);
    }
}