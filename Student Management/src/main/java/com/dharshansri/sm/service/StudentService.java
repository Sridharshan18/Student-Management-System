package com.dharshansri.sm.service;


import com.dharshansri.sm.DTO.Student;

import java.util.List;

public interface StudentService {

    List<Student> loadStudents();

    public void saveStudents(Student student);

    public Student getStudent(int id);

    public void updateStudent(Student student);

    public void deleteStudent(int id);

}
