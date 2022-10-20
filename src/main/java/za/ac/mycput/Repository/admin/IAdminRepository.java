package za.ac.mycput.Repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.mycput.Domain.Admin;


import java.util.Set;
/*
    Author : Devon Sherwyn May
    Student number : 219168296
    Date : 10 April 2022
    IAdminRepository.Java
*/
@Repository
public interface IAdminRepository  extends JpaRepository<Admin,String> {}