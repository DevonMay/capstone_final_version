package za.ac.mycput.Controller.employee;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.mycput.Domain.Employee;
import za.ac.mycput.Factory.EmployeeFactory;
import java.util.Arrays;

/*
Devon May (219168296)
 */

import static org.junit.jupiter.api.Assertions.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURl;
    private Employee employee;


    @BeforeEach
    void setUp()
    {
        this.employee= EmployeeFactory.build("Rufus","May","061369854","Driver","32");
        this.baseURl="http://localhost:" +this.port+ "/Food-distribution/employee/";
    }

    @Test
    void a_save()
    {
        String url = baseURl + "save";
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate.postForEntity(url,this.employee,Employee.class);
        System.out.println(response);
        assertAll(

                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void b_read()
    {
        String url = baseURl + "read/" + this.employee.getEmpID();
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate.getForEntity(url, Employee.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK, response.getStatusCode())

        );
    }
    @Test
    void c_update()
    {
        Employee updated = new Employee.Builder().copy(employee).EmpFirstName("Chad").build();
        String url = baseURl + "/update/" + this.employee.getEmpID();
        System.out.println("Post data: " + updated);
        ResponseEntity<Employee> response = restTemplate.postForEntity(url, updated, Employee.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete()
    {
        String url = baseURl + "delete/" + this.employee.getEmpID();
        this.restTemplate.delete(url);
    }

    @Test
    void d_getAll()
    {
        String url = baseURl + "all";
        System.out.println(url);
        ResponseEntity<Employee[]> response = this.restTemplate.getForEntity(url, Employee[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertTrue(response.getBody().length==0)

        );
    }
}