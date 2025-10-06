package com.dharshansri.sm.DAO;

import com.dharshansri.sm.DTO.Student;
import com.dharshansri.sm.mapper.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> loadStudents() {

        //Some logic to get the Data
        String sql = "SELECT * FROM students";

        List<Student> listOfStudents = jdbcTemplate.query(sql, new StudentRowMapper());

        for(Student temp : listOfStudents)
        {
            System.out.println(temp);
        }

        return listOfStudents;
    }

    @Override
    public void saveStudent(Student student) {
        // Write logic to save the Data to the DB

        Object[] sqlParameters = {student.getName(),student.getMobile(),student.getCountry()};

        String sql = "insert into students(name,mobile,country) values (?,?,?)";

        jdbcTemplate.update(sql,sqlParameters);

        System.out.println("1 Record Updated");
    }

    @Override
    public Student getStudent(int id) {
        String sql = "SELECT * FROM students WHERE ID = ?";
        Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);

        return student;
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE STUDENTS SET name = ? , mobile = ? , country = ? WHERE id=?";
        jdbcTemplate.update(sql,student.getName(),student.getMobile(),student.getCountry(),student.getId());
        System.out.println("1 Record Updated");
    }

    @Override
    public void deleteStudent(int id)
    {
        String sql = "DELETE FROM STUDENTS WHERE ID = ?";
        jdbcTemplate.update(sql,id);

        System.out.println("1 Record Deleted");
    }
}
