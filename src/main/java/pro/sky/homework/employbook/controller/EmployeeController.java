package pro.sky.homework.employbook.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.homework.employbook.model.Employee;
import pro.sky.homework.employbook.service.EmployeeService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam int salary,
                                @RequestParam int departmentId) {
        return service.add(firstName, lastName, salary, departmentId);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam int salary,
                                   @RequestParam int departmentId) {
        return service.remove(firstName, lastName, salary, departmentId);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam int salary,
                         @RequestParam int departmentId) {
        return service.find(firstName, lastName, salary, departmentId);
    }

    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }
}
