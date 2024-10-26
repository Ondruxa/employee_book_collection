package pro.sky.homework.employbook.service;

import org.springframework.stereotype.Service;
import pro.sky.homework.employbook.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findEmployeeWithMinSalaryOnDepartment(int departmentNumberId) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(employee -> employee.getDepartmentId() == departmentNumberId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);

    }

    public Employee findEmployeeWithMaxSalaryOnDepartment(int departmentNumberId) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(emp -> emp.getDepartmentId() == departmentNumberId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getAllEmployeeByDepartment(int departmentNumberId) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(emp -> emp.getDepartmentId() == departmentNumberId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.getAllEmployees()
                .stream().
                collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
