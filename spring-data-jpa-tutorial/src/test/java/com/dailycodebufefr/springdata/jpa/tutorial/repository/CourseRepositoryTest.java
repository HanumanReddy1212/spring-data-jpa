package com.dailycodebufefr.springdata.jpa.tutorial.repository;

import com.dailycodebufefr.springdata.jpa.tutorial.entity.Course;
import com.dailycodebufefr.springdata.jpa.tutorial.entity.Student;
import com.dailycodebufefr.springdata.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
@Autowired
    private CourseRepository courseRepository;

@Test
public void printCourses(){
    List<Course> courseList=
    courseRepository.findAll();
    System.out.println("courseList = " + courseList);
}
    @Test
public void saveCourseWithTeacher(){
    Teacher teacher=Teacher.builder().firstName("Priya").lastName("SIngh").build();
    Course course=Course.builder().
     title("python").credit(6).teacher(teacher)
    .build();
        courseRepository.save(course);
}

@Test
    public void findAllPagination(){
    Pageable firstPageWithThreeRecords= PageRequest.of(0,3);
    Pageable firstPageWithTwoRecords= PageRequest.of(1,2);
    List<Course> courses=courseRepository.findAll(firstPageWithTwoRecords).getContent();
    long totalElements=courseRepository.findAll(firstPageWithTwoRecords).getTotalElements();
    long totalPages=courseRepository.findAll(firstPageWithTwoRecords).getTotalPages();
    System.out.println("totalPages = " + totalPages);
    System.out.println("totalElements = " + totalElements);
    System.out.println("courses = " + courses);
}
//pagination with sorting
    @Test
    public void findAllWithSorting(){
    Pageable sortByTitle=PageRequest.of(0,2, Sort.by("title"));
        Pageable sortByCreditDesc=PageRequest.of(0,2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc=PageRequest.of(0,2, Sort.by("title").descending().and(Sort.by("credit")));

List<Course> courses=courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);

        }

        @Test
    public void printfindByTitleContaining(){
    Pageable firstPageTenRecords=
    PageRequest.of(0,10);
            List<Course> courses=courseRepository.findByTitleContaining("D",firstPageTenRecords).getContent();
            System.out.println("courses = " + courses);
        }
    @Test
        public void saveCourseWithStudentAndTeacher(){

        Student student=Student.builder()
                .firstName("abhi").lastName("singh").emailId("abhi@gmail.com")
                .build();
    Teacher teacher=Teacher.builder()
            .lastName("sam").firstName("rao")

            .build();
    Course course=Course.builder().
            title("AI").credit(9).teacher(teacher).build();

    course.addStudent(student);
    courseRepository.save(course);
        }


}