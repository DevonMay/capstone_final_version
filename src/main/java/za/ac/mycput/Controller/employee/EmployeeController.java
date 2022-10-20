package za.ac.mycput.Controller.employee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.mycput.Domain.Employee;
import za.ac.mycput.Service.employee.IEmployeeService;

import javax.validation.Valid;
import java.util.Set;
/*
 * EmployeeController.Java
 * Entity for Employee
 * Author: Devon Sherwyn May (219168296)
 * Date: 26th October 2022
 * */
@Slf4j
@RestController
@RequestMapping("Food-distribution/employee/")
public class EmployeeController
{
    private final IEmployeeService employeeService;
    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("save")
    public ResponseEntity<Employee>save(@Valid @RequestBody Employee employee)
    {
        log.info("save request: {}", employee);
        Employee save = employeeService.save(employee);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Employee>read (@PathVariable String id)
    {
        log.info("Read request: {}", id);
        Employee employee = this.employeeService.read(id);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>delete(@PathVariable String id)
    {
        log.info("Read request: {}", id);
        this.employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<Set<Employee>> getAll()
    {
        Set<Employee> employee=this.employeeService.getAll();
        return ResponseEntity.ok(employee);
    }
}
