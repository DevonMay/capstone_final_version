package za.ac.mycput.Service.employee.Impl;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.mycput.Domain.Employee;
import za.ac.mycput.Factory.EmployeeFactory;
import za.ac.mycput.FoodManagementSystemApplication;
import java.util.Set;

/*
Devon May (219168296)
 */

import static org.junit.jupiter.api.Assertions.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes= FoodManagementSystemApplication.class)
class EmployeeServiceTest {

    private final Employee employee = EmployeeFactory.build("Sherwyn","Hartzenberg","059874563","Driver","31");
    private Employee empSaved;
    @Autowired
    private EmployeeService employeeService;

    void createEmployee(Employee employee1){empSaved=employeeService.save(employee1);}


    @Test
    void a_save()
    {
        createEmployee(employee);
        assertEquals("Sherwyn",empSaved.getEmpFirstName());
        System.out.println(empSaved);
    }

    @Test
    void b_read()
    {
        createEmployee(employee);
        Employee read = employeeService.read(empSaved.getEmpID());
        System.out.println("Read" + read);
    }

    @Test
    void c_update()
    {
        createEmployee(employee);
        Employee update = new Employee.Builder()
                .copy(employee)
                .EmpFirstName("Herman")
                .build();
        employeeService.update(update);
        System.out.println("Updated" + update);
    }

    @Test
    void e_delete()
    {
        createEmployee(employee);
        boolean delete = employeeService.delete(empSaved.getEmpID());
        assertTrue(delete);
    }

    @Test
    void d_getAll()
    {
        Set<Employee> employeeSet= employeeService.getAll();
        System.out.println(employeeSet);
    }
}