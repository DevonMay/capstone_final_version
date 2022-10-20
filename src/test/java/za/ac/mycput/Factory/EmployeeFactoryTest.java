package za.ac.mycput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.mycput.Domain.Employee;
/*
 * EmployeeFactoryTest.Java
 * Entity for Employee Factory test
 * Author: Devon Sherwyn May (219168296)
 * Date: 26th October 2022
 * */
import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    void build()
    {
        Employee employee = EmployeeFactory.build("Mark","Luke","01111111","Administration","Ad01");
        System.out.println(employee);
        assertNotNull(employee);
    }
}