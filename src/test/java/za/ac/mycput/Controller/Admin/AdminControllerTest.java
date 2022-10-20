package za.ac.mycput.Controller.Admin;

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
import za.ac.mycput.Domain.Admin;
import za.ac.mycput.Domain.Sales;
import za.ac.mycput.Factory.AdminFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminControllerTest
{
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    private Admin admin;
    private String baseURl;

    @BeforeEach
    void setUP()
    {
        this.admin=AdminFactory.build("Luke","Mark","02222222","30");
        this.baseURl="http://localhost:" +this.port+ "/Food-distribution/admin/";
    }

    @Test
    void a_save()
    {
        String url = baseURl + "save";
        System.out.println(url);
        ResponseEntity<Admin> response = this.restTemplate.postForEntity(url,this.admin,Admin.class);
        System.out.println(response);
        assertAll(

                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }
    @Test
    void b_read()
    {
        String url = baseURl + "read/" + this.admin.getAdminID();
        System.out.println(url);
        ResponseEntity<Admin> response = this.restTemplate.getForEntity(url, Admin.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK, response.getStatusCode())

        );
    }
    @Test
    void c_update()
    {
        Admin updated = new Admin.Builder().copy(admin).adminFirstName("Devon").build();
        String url = baseURl + "/update/" + this.admin.getAdminID();
        System.out.println("Post data: " + updated);
        ResponseEntity<Admin> response = restTemplate.postForEntity(url, updated, Admin.class);
        assertNotNull(response.getBody());
    }
    @Test
    void e_delete()
    {
        String url = baseURl + "delete/" +this.admin.getAdminID();
        this.restTemplate.delete(url);
    }
    @Test
    void d_getAll(){
        String url = baseURl + "all";
        System.out.println(url);
        ResponseEntity<Admin[]> response = this.restTemplate.getForEntity(url, Admin[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertTrue(response.getBody().length==4)

        );
    }
}