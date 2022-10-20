package za.ac.mycput.Service.employee;


import za.ac.mycput.Domain.Employee;
import za.ac.mycput.Service.IService;
/*
 * IEmployeeService.Interface
 * Entity for Employee
 * Author: Devon Sherwyn May (219168296)
 * Date: 26th October 2022
 * */
import java.util.List;
import java.util.Set;

public interface IEmployeeService extends IService<Employee, String>
{
    Set<Employee> getAll();
}
