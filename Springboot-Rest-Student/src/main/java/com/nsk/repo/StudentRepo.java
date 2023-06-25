package com.nsk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsk.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
