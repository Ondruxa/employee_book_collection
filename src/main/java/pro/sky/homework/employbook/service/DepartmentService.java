package pro.sky.homework.employbook.service;

import pro.sky.homework.employbook.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee findEmployeeWithMaxSalaryOnDepartment(int departmentNumberId);

    Employee findEmployeeWithMinSalaryOnDepartment(int departmentNumberId);

    List<Employee> getAllEmployeeByDepartment(int departmentNumberId);

    Map<Integer, List<Employee>> getAllEmployees();

}
