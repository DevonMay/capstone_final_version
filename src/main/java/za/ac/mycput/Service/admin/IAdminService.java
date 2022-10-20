package za.ac.mycput.Service.admin;

import za.ac.mycput.Domain.Admin;
import za.ac.mycput.Service.IService;

import java.util.List;
import java.util.Set;
/*
 * AdminService.interface
 * Entity for Admin
 * Author: Devon Sherwyn May (219168296)
 * Date: 26th October 2022
 * */
public interface IAdminService extends IService<Admin, String>
{
    Set<Admin> getAll();
}