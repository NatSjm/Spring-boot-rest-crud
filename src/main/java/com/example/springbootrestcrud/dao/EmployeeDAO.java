package com.example.springbootrestcrud.dao;

import com.example.springbootrestcrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
