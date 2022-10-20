package za.ac.mycput.Controller.Admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.mycput.Domain.Admin;
import za.ac.mycput.Service.admin.IAdminService;
import javax.validation.Valid;
import java.util.Set;

/*
 * AdminController.Java
 * Entity for Admin
 * Author: Devon Sherwyn May (219168296)
 * Date: 26th October 2022
 * */
@RestController
@RequestMapping("Food-distribution/admin/")
@Slf4j
public class AdminController
{
    private final IAdminService adminService;
    @Autowired
    public AdminController(IAdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("save")
    public ResponseEntity<Admin> save(@Valid @RequestBody Admin admin)
    {
        log.info("save request: {}", admin);
        Admin save=adminService.save(admin);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Admin> read (@PathVariable String id)
    {
        log.info("Read request: {}", id);
        Admin admin=this.adminService.read(id);
        return ResponseEntity.ok(admin);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>delete(@PathVariable String id)
    {
        log.info("Read Request: {}", id);
        this.adminService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<Set<Admin>> getAll(){
        Set<Admin> admin =this.adminService.getAll();
        return ResponseEntity.ok(admin);
    }
}