package za.ac.mycput.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
 * Employee.Java
 * Entity for Employee
 * Author: Devon Sherwyn May (219168296)
 * Date: 26th October 2022
 * */
@Entity
@Table(name= "employee")
public class Employee implements Serializable
{
    @NotNull
    private String empFirstName,empLastName,empPhoneNumber,empRole;
    @Id
    @Column(name="employee_id")
    private String empID;

    protected Employee(){}
    private Employee (Builder builder)
    {
        this.empFirstName=builder.empFirstName;
        this.empLastName=builder.empLastName;
        this.empPhoneNumber = builder.empPhoneNumber;
        this.empRole= builder.empRole;
        this.empID=builder.empID;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }
    public String getEmpLastName() {
        return empLastName;
    }
    public String getEmpPhoneNumber() {
        return empPhoneNumber;
    }
    public String getEmpRole() {
        return empRole;
    }
    public String getEmpID() {
        return empID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                ", empPhoneNumber='" + empPhoneNumber + '\'' +
                ", empRole='" + empRole + '\'' +
                ", empID='" + empID + '\'' +
                '}';
    }

    public static class Builder
    {
        private String empFirstName;
        private String empLastName;
        private String empPhoneNumber;
        private String empRole;
        private String empID;

        public Builder EmpFirstName(String empFirstName)
        {
            this.empFirstName = empFirstName;
            return this;
        }

        public Builder EmpLastName(String empLastName) {
            this.empLastName = empLastName;
            return this;
        }

        public Builder EmpPhoneNumber(String empPhoneNumber) {
            this.empPhoneNumber = empPhoneNumber;
            return this;
        }

        public Builder EmpRole(String empRole) {
            this.empRole = empRole;
            return this;
        }

        public Builder EmpID(String empID) {
            this.empID = empID;
            return this;
        }

        public Builder copy(Employee employee)
        {
            this.empFirstName = employee.empFirstName;
            this.empLastName = employee.empLastName;
            this.empPhoneNumber = employee.empPhoneNumber;
            this.empRole = employee.empRole;
            this.empID = employee.empID;
            return this;
        }
        public Employee build(){return new Employee(this);}
    }
}
