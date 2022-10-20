package za.ac.mycput.Factory;
/*
    Author : Devon Sherwyn May
    Student number : 219168296
    Date : 10 April 2022
    EmployeeFactory.Java
*/

import za.ac.mycput.Domain.Employee;

import static org.hibernate.validator.internal.util.StringHelper.isNullOrEmptyString;

public class EmployeeFactory
{
    public static Employee build(String empFirstName, String empLastName, String empPhoneNumber, String empRole, String empID)
    {
        if(isNullOrEmptyString(empID) ||isNullOrEmptyString(empFirstName)||isNullOrEmptyString(empLastName)||isNullOrEmptyString(empPhoneNumber))
        throw new IllegalArgumentException("Please fill in all fields ");
            return new Employee.Builder()
                .EmpFirstName(empFirstName)
                .EmpLastName(empLastName)
                .EmpPhoneNumber(empPhoneNumber)
                .EmpRole(empRole)
                .EmpID(empID)
                .build();
    }
}
