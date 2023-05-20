package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String,Student> s = new HashMap<>();;
    HashMap<String,Teacher> t = new HashMap<>();;
    HashMap<String,ArrayList<String>> st = new HashMap<>();;



    public void addStudent(Student student){
        s.put(student.getName(),student);

    }

    public void addTeacher(Teacher teacher){
        t.put(teacher.getName(),teacher);

    }

    public void addStudentTeacherPair(String teacher,String student){
        if(!st.containsKey(teacher)){
           st.put(teacher,new ArrayList<>());
        }
        st.get(teacher).add(student);

    }

    public Student getStudentByName(String student){

        return s.get(student);


    }

    public Teacher getTeacherByName(String teacher){

        return t.get(teacher);


    }

    public List<String> getStudentsByTeacherName(String teacher){

        return st.get(teacher);


    }

    public List<String> getAllStudents(){

        List<String> list = new ArrayList<>();
        for (String st : s.keySet()){
            list.add(st);
        }
        return list;


    }

    public void deleteTeacherByName(String teacher){

        if(t.containsKey(teacher)) t.remove(teacher);

        if(st.containsKey(teacher)){
            for(String student : st.get(teacher))
                s.remove(student);

            st.remove(teacher);
        }




    }

    public void deleteAllTeachers(){

        for(String teacher: t.keySet())
        deleteTeacherByName(teacher);
    }


}
