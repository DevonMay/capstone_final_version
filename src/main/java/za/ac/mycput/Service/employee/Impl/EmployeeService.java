package za.ac.mycput.Service.employee.Impl;

import org.springframework.stereotype.Service;
import za.ac.mycput.Domain.Employee;
import za.ac.mycput.Repository.employee.IEmployeeRepository;
import za.ac.mycput.Service.employee.IEmployeeService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    @Override
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee read(String empID) {
        return this.employeeRepository.findById(empID).orElse(null);
    }

    @Override
    public Employee update(Employee employee) {
        if(this.employeeRepository.existsById(employee.getEmpID()))
            return this.employeeRepository.save(employee);
        return employee;
    }

    @Override
    public boolean delete(String empID) {
        this.employeeRepository.deleteById(empID);
        if(this.employeeRepository.existsById(empID)){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Set<Employee> getAll() {
        return this.employeeRepository.findAll().stream().collect(Collectors.toSet());
    }
}
