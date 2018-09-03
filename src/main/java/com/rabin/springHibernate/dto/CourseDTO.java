package com.rabin.springHibernate.dto;

import com.rabin.springHibernate.model.Course;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CourseDTO {

    public String id;
    @NotEmpty(message = "Course name cannot be empty")
    @Pattern(regexp = "^([a-zA-Z.]+(_[a-zA-Z.]+)*)(\\s([a-zA-Z.]+(_[a-zA-Z.]+)*))*$", message = "Not valid pattern")
    public String courseName;
    public String createdDate;
    public String updatedDate;

    public CourseDTO() {

    }

    public CourseDTO(String id, String courseName, String createdDate, String updatedDate) {
        this.id = id;
        this.courseName = courseName;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public CourseDTO(Course course){
        this.id = course.getId().toString();
        this.courseName = course.getCourseName().toString();
        this.createdDate = course.getCreatedDate().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}
