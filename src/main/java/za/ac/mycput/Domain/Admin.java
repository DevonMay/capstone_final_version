package za.ac.mycput.Domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

/*
* Admin.Java
* Entity for Admin
* Author: Devon Sherwyn May (219168296)
* Date: 26th October 2022
* */
@Entity
@Table(name = "admin")
public class Admin implements Serializable
{
    @NotNull
    private String adminFirstName, adminLastName, adminPhoneNumber;
    @Id
    @Column(name = "admin_id")
    private String adminID;


    protected Admin() {}

    private Admin(Builder builder) {
        this.adminFirstName = builder.adminFirstName;
        this.adminLastName = builder.adminLastName;
        this.adminPhoneNumber = builder.adminPhoneNumber;
        this.adminID = builder.adminID;

    }

    public String getAdminFirstName() {
        return adminFirstName;
    }

    public String getAdminLastName() {
        return adminLastName;
    }

    public String getAdminPhoneNumber() {
        return adminPhoneNumber;
    }

    public String getAdminID() {
        return adminID;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminFirstName='" + adminFirstName + '\'' +
                ", adminLastName='" + adminLastName + '\'' +
                ", adminPhoneNumber='" + adminPhoneNumber + '\'' +
                ", adminID='" + adminID + '\'' +
                '}';
    }

    public static class Builder {
        private String adminFirstName;
        private String adminLastName;
        private String adminPhoneNumber;
        private String adminID;


        public Builder adminFirstName(String adminFirstName) {
            this.adminFirstName = adminFirstName;
            return this;
        }

        public Builder adminLastName(String adminLastName) {
            this.adminLastName = adminLastName;
            return this;
        }

        public Builder adminPhoneNumber(String adminPhoneNumber) {
            this.adminPhoneNumber = adminPhoneNumber;
            return this;
        }

        public Builder adminID(String adminID) {
            this.adminID = adminID;
            return this;
        }

        public Builder copy(Admin admin) {
            this.adminFirstName = admin.adminFirstName;
            this.adminLastName = admin.adminLastName;
            this.adminPhoneNumber = admin.adminPhoneNumber;
            this.adminID = admin.adminID;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}