package com.site.plat.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String teacher;

    @Column(nullable = false)
    private String academicYear;

    @Column
    private Integer score1;

    @Column
    private Integer score2;

    @Column
    private Integer score3;

    @Column
    private Integer score4;

    @Column
    private Integer score5;

    @Column
    private Integer score6;

    @Column
    private Integer score7;

    @Column
    private Integer score8;

    @Column
    private Integer score9;

    @Column
    private Integer score10;

    @Column
    private Integer score11;

    @Column
    private Integer score12;

    @Column
    private Integer score13;

    @Column
    private Integer score14;

    @Column
    private Integer score15;

    @Column
    private Integer tk1;

    @Column
    private Integer tk2;

    @Column
    private Integer pk1;

    @Column
    private Integer pk2;

    @Column
    private Integer finalScore;

    @Column
    private Integer rating;

    @Column
    private Integer completionPercentage;

    @Column
    private Integer additionalScore;

    @Column
    private String notes;

    @Column(nullable = false)
    private LocalDateTime dateAdded;

    // Конструкторы
    public Grade() {
        this.dateAdded = LocalDateTime.now();
    }

    public Grade(User user, String subject, String teacher, String academicYear) {
        this.user = user;
        this.subject = subject;
        this.teacher = teacher;
        this.academicYear = academicYear;
        this.dateAdded = LocalDateTime.now();
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getTeacher() { return teacher; }
    public void setTeacher(String teacher) { this.teacher = teacher; }
    public String getAcademicYear() { return academicYear; }
    public void setAcademicYear(String academicYear) { this.academicYear = academicYear; }
    public Integer getScore1() { return score1; }
    public void setScore1(Integer score1) { this.score1 = score1; }
    public Integer getScore2() { return score2; }
    public void setScore2(Integer score2) { this.score2 = score2; }
    public Integer getScore3() { return score3; }
    public void setScore3(Integer score3) { this.score3 = score3; }
    public Integer getScore4() { return score4; }
    public void setScore4(Integer score4) { this.score4 = score4; }
    public Integer getScore5() { return score5; }
    public void setScore5(Integer score5) { this.score5 = score5; }
    public Integer getScore6() { return score6; }
    public void setScore6(Integer score6) { this.score6 = score6; }
    public Integer getScore7() { return score7; }
    public void setScore7(Integer score7) { this.score7 = score7; }
    public Integer getScore8() { return score8; }
    public void setScore8(Integer score8) { this.score8 = score8; }
    public Integer getScore9() { return score9; }
    public void setScore9(Integer score9) { this.score9 = score9; }
    public Integer getScore10() { return score10; }
    public void setScore10(Integer score10) { this.score10 = score10; }
    public Integer getScore11() { return score11; }
    public void setScore11(Integer score11) { this.score11 = score11; }
    public Integer getScore12() { return score12; }
    public void setScore12(Integer score12) { this.score12 = score12; }
    public Integer getScore13() { return score13; }
    public void setScore13(Integer score13) { this.score13 = score13; }
    public Integer getScore14() { return score14; }
    public void setScore14(Integer score14) { this.score14 = score14; }
    public Integer getScore15() { return score15; }
    public void setScore15(Integer score15) { this.score15 = score15; }
    public Integer getTk1() { return tk1; }
    public void setTk1(Integer tk1) { this.tk1 = tk1; }
    public Integer getTk2() { return tk2; }
    public void setTk2(Integer tk2) { this.tk2 = tk2; }
    public Integer getPk1() { return pk1; }
    public void setPk1(Integer pk1) { this.pk1 = pk1; }
    public Integer getPk2() { return pk2; }
    public void setPk2(Integer pk2) { this.pk2 = pk2; }
    public Integer getFinalScore() { return finalScore; }
    public void setFinalScore(Integer finalScore) { this.finalScore = finalScore; }
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
    public Integer getCompletionPercentage() { return completionPercentage; }
    public void setCompletionPercentage(Integer completionPercentage) { this.completionPercentage = completionPercentage; }
    public Integer getAdditionalScore() { return additionalScore; }
    public void setAdditionalScore(Integer additionalScore) { this.additionalScore = additionalScore; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public LocalDateTime getDateAdded() { return dateAdded; }
    public void setDateAdded(LocalDateTime dateAdded) { this.dateAdded = dateAdded; }
}