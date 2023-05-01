package com.dailycodebufefr.springdata.jpa.tutorial.repository;

import com.dailycodebufefr.springdata.jpa.tutorial.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    //custom sorting
    Page<Course> findByTitleContaining(String title, Pageable pageRequest);
}
