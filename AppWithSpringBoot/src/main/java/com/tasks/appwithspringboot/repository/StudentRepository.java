package com.tasks.appwithspringboot.repository;


import com.tasks.appwithspringboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Integer> {

    Student findDistinctById (Integer id);
}
