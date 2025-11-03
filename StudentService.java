package com.example.app.service;

import com.example.app.dao.StudentDAO;
import com.example.app.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Transactional
    public void createStudent(Student s) {
        studentDAO.saveStudent(s);
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Transactional
    public void updateStudent(Student s) {
        studentDAO.updateStudent(s);
    }

    @Transactional
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }
}
