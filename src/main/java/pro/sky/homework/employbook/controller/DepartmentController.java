package pro.sky.homework.employbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework.employbook.model.Employee;
import pro.sky.homework.employbook.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("max-salary")
    public Employee findEmployeeWithMaxSalaryOnDepartment(@RequestParam int departmentId) {
        return departmentService.findEmployeeWithMaxSalaryOnDepartment(departmentId);
    }

    @GetMapping("min-salary")
    public Employee findEmployeeWithMinSalaryOnDepartment(@RequestParam int departmentId) {
        return departmentService.findEmployeeWithMinSalaryOnDepartment(departmentId);
    }

    @GetMapping("all-department")
    public List<Employee> getAllEmployeeByDepartment(@RequestParam() int departmentId) {
        return departmentService.getAllEmployeeByDepartment(departmentId);
    }

    @GetMapping("all")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployees();
    }

}
