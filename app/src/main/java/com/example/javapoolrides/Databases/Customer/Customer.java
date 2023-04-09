package com.example.javapoolrides.Databases.Customer;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import controllers.encryptionController;

@Entity
public class Customer {
    //key to distinguish the object
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "phone")
    public String phone;

    @ColumnInfo(name = "firstname")
    public String firstName;

    @ColumnInfo(name = "lastname")
    public String lastName;

    public Customer(String username, String password, String email, String phone, String firstName, String lastName) {
        encryptionController E = new encryptionController();
        int key = E.getKey();
        this.username = E.decrypt(username, key);
        this.password = E.decrypt(password, key);
        this.email = E.decrypt(email, key);
        this.phone = E.decrypt(phone, key);
        this.firstName = E.decrypt(firstName, key);
        this.lastName = E.decrypt(lastName, key);

    }
}
