package com.rabin.springHibernate.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    public Long id;
    @Column(name = "course_name")
    public String courseName;
    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    public LocalDateTime createdDate;
    @UpdateTimestamp
    @Column(name = "updated_date")
    public LocalDateTime updatedDate;

    public Course(){

    }

    public Course(Long id, String courseName){
        this.id = id;
        this.courseName = courseName;
    }

    public Course(String courseName, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.courseName = courseName;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}


