package com.site.plat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;        // День недели (например, "Понедельник")
    private String time;       // Время занятия (например, "10:00-11:30")
    private String groupName;  // Группа (для студентов) или предмет (для преподавателя)
    private String subject;    // Предмет
    private String room;       // Аудитория
    private String teacher;    // Преподаватель (для студентов)

    // Конструкторы
    public Schedule() {}

    public Schedule(String day, String time, String groupName, String subject, String room, String teacher) {
        this.day = day;
        this.time = time;
        this.groupName = groupName;
        this.subject = subject;
        this.room = room;
        this.teacher = teacher;
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDay() { return day; }
    public void setDay(String day) { this.day = day; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getRoom() { return room; }
    public void setRoom(String room) { this.room = room; }
    public String getTeacher() { return teacher; }
    public void setTeacher(String teacher) { this.teacher = teacher; }
}