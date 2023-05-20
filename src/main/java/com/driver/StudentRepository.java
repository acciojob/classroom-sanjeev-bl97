package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

    Map<String,Student> s;
    Map<String,Teacher> t;
    Map<String,ArrayList<String>> st;

    public StudentRepository() {
        s = new HashMap<>();
        t = new HashMap<>();
        st = new HashMap<>();

    }

    public void addStudent(Student student){
        s.put(student.getName(),student);

    }

    public void addTeacher(Teacher teacher){
        t.put(teacher.getName(),teacher);

    }

    public void addStudentTeacherPair(String teacher,String student){
        if(t.containsKey(teacher) && s.containsKey(student)){
            ArrayList<String> al = st.get(teacher);
            if(al == null)
                al = new ArrayList<>();
            al.add(student);
            st.put(teacher,al);
        }

    }

    public Student getStudentByName(String student){

        return s.get(student);


    }

    public Teacher getTeacherByName(String teacher){

        return t.get(teacher);


    }

    public ArrayList<String> getStudentsByTeacherName(String teacher){

        return st.get(teacher);


    }

    public ArrayList<String> getAllStudents(){

        return new ArrayList<>(s.keySet());


    }

    public void deleteTeacherByName(String teacher){

        if(t.containsKey(teacher)) t.remove(teacher);

        if(st.containsKey(teacher)){
            ArrayList<String> s = st.get(teacher);

            for(String student : s)
                s.remove(student);

            st.remove(teacher);
        }




    }

    public void deleteAllTeachers(){

        for(String teacher: t.keySet())
        deleteTeacherByName(teacher);
    }


}
