package za.ac.mycput.Service.admin.Impl;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.mycput.Domain.Admin;
import za.ac.mycput.Factory.AdminFactory;
import za.ac.mycput.FoodManagementSystemApplication;
import java.util.Set;
/*
Devon May (219168296)
 */

import static org.junit.jupiter.api.Assertions.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes= FoodManagementSystemApplication.class)
class AdminServiceTest
{
    private final Admin admin = AdminFactory.build("Devon", "May","0662658693","1");
    private Admin adminSaved;
    @Autowired
    private AdminService adminService;

    void createAdmin(Admin admin1){adminSaved=adminService.save(admin1);}

    @Test
    public void a_save()
    {
        createAdmin(admin);
        assertEquals("Devon",adminSaved.getAdminFirstName());
        System.out.println(adminSaved);
    }

    @Test
    public void b_read()
    {
        createAdmin(admin);
        Admin read=adminService.read(adminSaved.getAdminID());
        System.out.println("Read: "+ read);
    }

    @Test
    public void c_update()
    {
        createAdmin(admin);
        Admin update = new Admin.Builder()
                .copy(admin)
                .adminLastName("Pay")
                .build();
        adminService.update(update);
        System.out.println("updated" + update);
    }

    @Test
    public void e_delete()
    {
        createAdmin(admin);
        boolean delete=adminService.delete(adminSaved.getAdminID());
        assertTrue(delete);
    }

    @Test
    public void d_getAll()
    {
        Set<Admin>adminSet= adminService.getAll();
        System.out.println(adminSet);
    }
}
