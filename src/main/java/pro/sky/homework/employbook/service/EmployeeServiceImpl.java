package pro.sky.homework.employbook.service;

import org.springframework.stereotype.Service;
import pro.sky.homework.employbook.exception.EmployeeAlreadyAddedException;
import pro.sky.homework.employbook.exception.EmployeeNotFoundException;
import pro.sky.homework.employbook.model.Employee;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int STORAGE_SIZE = 11;

    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee add(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (this.employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        this.employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int salary, int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (this.employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());

        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, int salary, int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (this.employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
