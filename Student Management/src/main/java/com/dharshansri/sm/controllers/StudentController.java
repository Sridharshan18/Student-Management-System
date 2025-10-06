package com.dharshansri.sm.controllers;


import com.dharshansri.sm.DAO.StudentDAO;
import com.dharshansri.sm.DTO.Student;
import com.dharshansri.sm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String showHomePage() {
        return "home";  // this corresponds to /WEB-INF/views/home.jsp
    }

    @GetMapping("/showStudent")
    public String showStudentList(Model model)
    {
        // Call the DAO Method to get the Data
        List<Student> students = studentService.loadStudents();
        model.addAttribute("studentList",students);

        return "student-list";
    }

    @GetMapping("/showAddStudentPage")
    public String addStudent(Model model)
    {
        // Call the DAO Method to get the Data
        Student student = new Student();
        model.addAttribute("students",student);

        return "add-student";
    }

    @PostMapping("/showSaveStudentPage")
    public String saveStudent(Student student)
    {
        //Logic to save the Student Data

        //do a condition check
        //if the user does not have a id then do insert
        //if the user have the id already then do a update

        if(student.getId()==0)
        {
            studentService.saveStudents(student);
        }
        else
        {
            studentService.updateStudent(student);
        }

        System.out.println(student);


        //PRG
        return "redirect:/showStudent";
    }

    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam("userId") int id , Model model)
    {
        Student myStudent = studentService.getStudent(id);
        model.addAttribute("students",myStudent);
        return "add-student";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("userId") int id)
    {

        // capture the id and delete the user
        studentService.deleteStudent(id);

        return "redirect:/showStudent";
    }
}
