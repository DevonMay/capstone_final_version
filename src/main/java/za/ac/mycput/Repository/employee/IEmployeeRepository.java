package za.ac.mycput.Repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.mycput.Domain.Employee;
/*
    Author : Devon Sherwyn May
    Student number : 219168296
    Date : 26 October 2022
    IEmployeeRepository.Java
*/

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String>
{
}
