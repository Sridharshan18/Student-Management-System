package com.dharshansri.sm.DAO;

import com.dharshansri.sm.DTO.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> loadStudents();
    public void saveStudent(Student student);
    public Student getStudent(int id);

    public void updateStudent(Student student);

    public void deleteStudent(int id);
}
