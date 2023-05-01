package com.dailycodebufefr.springdata.jpa.tutorial.repository;

import com.dailycodebufefr.springdata.jpa.tutorial.entity.Course;
import com.dailycodebufefr.springdata.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial(){
        Course course= Course.builder().title(".net").credit(6).build();
        CourseMaterial courseMaterial=CourseMaterial.builder()
                //.url("www.google.com")
                .url("www.failly.com")
                .course(course)// we will get error if comment this and give optional =false which means required
        .build();
        repository.save(courseMaterial);
    }

    @Test
    public void printCourseMaterials(){
        List<CourseMaterial> courseMaterialList=repository.findAll();
        System.out.println("courseMaterialList = " + courseMaterialList);
    }
}