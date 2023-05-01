package com.dailycodebufefr.springdata.jpa.tutorial.repository;

import com.dailycodebufefr.springdata.jpa.tutorial.entity.Course;
import com.dailycodebufefr.springdata.jpa.tutorial.entity.CourseMaterial;
import com.dailycodebufefr.springdata.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher(){
        Course course=Course.builder().title("DBA").credit(9).build();
        Course course1=Course.builder().title("java").credit(9).build();
        Teacher teacher= Teacher.builder().firstName("qutub").lastName("khan")
                //.courses(List.of(course,course1))
        .build();
        CourseMaterial courseMaterial=CourseMaterial.builder().url("www.google.com").course(course).build();
        repository.save(teacher);
    }

}