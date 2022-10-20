package za.ac.mycput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.mycput.Domain.Admin;
/*
 * AdminFactoryTest.Java
 * Entity for Admin Factory test
 * Author: Devon Sherwyn May (219168296)
 * Date: 26th October 2022
 * */
import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    @Test
    void build()
    {
     Admin admin = AdminFactory.build("Devon","May","02222222","01");
     System.out.println(admin);
     assertNotNull(admin);
    }
}