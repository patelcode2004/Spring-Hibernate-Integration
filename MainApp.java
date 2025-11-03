package com.example.app;

import com.example.app.config.AppConfig;
import com.example.app.entity.Student;
import com.example.app.entity.Account;
import com.example.app.service.StudentService;
import com.example.app.service.BankService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentService studentService = context.getBean(StudentService.class);
        BankService bankService = context.getBean(BankService.class);

        // --- Spring DI + Hibernate CRUD ---
        Student s1 = new Student("Vishal Patel", "Spring Boot");
        studentService.createStudent(s1);

        System.out.println("All Students: " + studentService.getAllStudents());

        // --- Transaction Management Example ---
        Account a1 = new Account(101, "Vishal", 5000);
        Account a2 = new Account(102, "Rahul", 3000);

        // Normally accounts would be saved first in DB
        // but for demonstration, assume they already exist.

        try {
            bankService.transferMoney(101, 102, 1000);
            System.out.println("Transaction Successful!");
        } catch (Exception e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }

        context.close();
    }
}
