package com.dailycodebufefr.springdata.jpa.tutorial.repository;

import com.dailycodebufefr.springdata.jpa.tutorial.entity.Guardian;
import com.dailycodebufefr.springdata.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest// to impact the database
class StudentRepositoryTest {
    @Autowired
    private  StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student=Student.builder()
        .emailId("shabbir@gmail.com")
                .firstName("shabbir").lastName("dawood")
//                .guardianName("Nikhil").guardianEmail("Nikhil@gmail.com")
//                        .guardianMobile("73838993")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian=Guardian.builder().
         email("Nikhil@gmail.com").mobile("73838993").name("Nikhil")
        .build();

        Student student=Student.builder()
                .firstName("Shiva").emailId("Shiva@gmail.com").lastName("sarkar").guardian(guardian)
                .build();
        studentRepository.save(student);
    }


    @Test
    public void printAllStudent(){
        List<Student> studentList=studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void printStudentByFirstName(){
        List<Student> studentList=studentRepository.findByFirstName("Shiva");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList=studentRepository.findByFirstNameContaining("Sh");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList=studentRepository.findByGuardianName("nikhil");
        System.out.println("studentList = " + studentList);
    }


    @Test
    public void printStudentByEmailAddress(){
       Student student=studentRepository.getStudentByEmailAddress("shabbir@gmail.com");
        System.out.println("student = " + student);
    }


    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstname=studentRepository.getStudentFirstNameByEmailAddress("Shiva@gmail.com");
        System.out.println("firstname = " + firstname);
    }
    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student=studentRepository.getStudentByEmailAddressNative("shabbir@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student=studentRepository.getStudentByEmailAddressNativeNamedParam("shabbir@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentByEmailId("shabbir dawoodi", "shabbir@gmail.com");
    }
}