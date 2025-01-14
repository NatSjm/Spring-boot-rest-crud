package com.example.springbootrestcrud.service;

import com.example.springbootrestcrud.dao.EmployeeRepository;
import com.example.springbootrestcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
   private final EmployeeRepository employeeRepository;

   @Autowired
   public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
       employeeRepository = theEmployeeRepository;
   }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {

       Employee theEmployee = null;

        Optional<Employee> result = employeeRepository.findById(theId);
        if(result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    //@Transactional is out of the box annotation provided by JPARespository.
    @Override
    public void deleteById(int theId) {
     employeeRepository.deleteById(theId);
    }
}
