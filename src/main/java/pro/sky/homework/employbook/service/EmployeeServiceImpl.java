package pro.sky.homework.employbook.service;

import org.springframework.stereotype.Service;
import pro.sky.homework.employbook.exception.EmployeeAlreadyAddedException;
import pro.sky.homework.employbook.exception.EmployeeNotFoundException;
import pro.sky.homework.employbook.model.Employee;

import java.util.*;

// забыл запушить ветку в начале
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl(List<Employee> employeeList) {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (this.employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        this.employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (this.employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());

        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (this.employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
