package za.ac.mycput.Factory;
/*
    Author : Devon Sherwyn May
    Student number : 219168296
    Date : 10 April 2022
    AdminFactory.Java
*/

import za.ac.mycput.Domain.Admin;

import static org.hibernate.validator.internal.util.StringHelper.isNullOrEmptyString;

public class AdminFactory
{
    public static Admin build(String adminFirstName, String adminLastName, String adminPhoneNumber, String adminID)
    {
        if (isNullOrEmptyString(adminID) || isNullOrEmptyString(adminFirstName) || isNullOrEmptyString(adminLastName)|| isNullOrEmptyString(adminPhoneNumber))
            throw new IllegalArgumentException("Please fill in all fields");
        return new Admin.Builder().adminID(adminID).adminFirstName(adminFirstName).adminLastName(adminLastName).adminPhoneNumber(adminPhoneNumber).build();
    }
}
