package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);

    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);

    }

    public void addStudentTeacherPair(String teacher,String student){
        studentRepository.addStudentTeacherPair(teacher,student);

    }

    public Student getStudentByName(String student){

        return studentRepository.getStudentByName(student);


    }

    public Teacher getTeacherByName(String teacher){

        return studentRepository.getTeacherByName(teacher);


    }

    public List<String> getStudentsByTeacherName(String teacher){

        return studentRepository.getStudentsByTeacherName(teacher);


    }

    public List<String> getAllStudents(){

        return studentRepository.getAllStudents();


    }

    public void deleteTeacherByName(String teacher){

        studentRepository.deleteTeacherByName(teacher);




    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();

    }

}
