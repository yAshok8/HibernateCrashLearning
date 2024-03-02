package com.example.hibernate.HibernateCrashLearning.services;

import com.example.hibernate.HibernateCrashLearning.entity.Department;
import com.example.hibernate.HibernateCrashLearning.entity.Employee;
import com.example.hibernate.HibernateCrashLearning.repository.DepartmentRepository;
import com.example.hibernate.HibernateCrashLearning.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department department) {
        Department existingDepartment = departmentRepository.findById(id).orElse(null);
        if (existingDepartment != null) {
            existingDepartment.setName(department.getName());
            for (Employee employee: department.getEmployees()) {
                employee.setDepartment(existingDepartment);
                employeeRepository.save(employee);
            }
            existingDepartment.setEmployees(department.getEmployees());
            // You can update other fields as needed
            return departmentRepository.save(existingDepartment);
        }
        return null; // Department with the given ID not found
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
