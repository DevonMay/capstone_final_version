package za.ac.mycput.Service.admin.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.mycput.Domain.Admin;
import za.ac.mycput.Factory.AdminFactory;
import za.ac.mycput.Repository.admin.IAdminRepository;
import za.ac.mycput.Service.admin.IAdminService;
/*
 * AdminService.Java
 * Entity for Admin
 * Author: Devon Sherwyn May (219168296)
 * Date: 26th October 2022
 * */
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminService implements IAdminService
{
    private final IAdminRepository adminRepository;

    public AdminService(IAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin save(Admin admin) {
        return this.adminRepository.save(admin);
    }

    @Override
    public Admin read(String adminID)
    {
        return this.adminRepository.findById(adminID).orElse(null);
    }

    @Override
    public Admin update(Admin admin)
    {
        if(this.adminRepository.existsById(admin.getAdminID()))
            return  this.adminRepository.save(admin);
        return admin;
    }

    @Override
    public boolean delete(String adminFirstName) {
        this.adminRepository.deleteById(adminFirstName);
        if (this.adminRepository.existsById(adminFirstName)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Set<Admin> getAll() {
        return this.adminRepository.findAll().stream().collect(Collectors.toSet());
    }
}

