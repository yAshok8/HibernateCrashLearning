package com.example.hibernate.HibernateCrashLearning.repository;

import com.example.hibernate.HibernateCrashLearning.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // You can add custom query methods if needed
}
