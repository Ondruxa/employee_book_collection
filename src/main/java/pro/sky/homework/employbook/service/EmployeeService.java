package pro.sky.homework.employbook.service;

import pro.sky.homework.employbook.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int salary, int departmentId);
    Employee remove(String firstName, String lastName, int salary, int departmentId);
    Employee find(String firstName, String lastName, int salary, int departmentId);

    Collection<Employee> getAllEmployees();
}
