/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hardwareStore.models;

/**
 *
 * @author Ronaldo Jiménez
 */
public class Users {
    public int Id;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean isLockoutEnabled() {
        return LockoutEnabled;
    }

    public void setLockoutEnabled(boolean LockoutEnabled) {
        this.LockoutEnabled = LockoutEnabled;
    }

    public String getLockoutEndDateUtc() {
        return LockoutEndDateUtc;
    }

    public void setLockoutEndDateUtc(String LockoutEndDateUtc) {
        this.LockoutEndDateUtc = LockoutEndDateUtc;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String Password;
    public boolean LockoutEnabled;
    public String LockoutEndDateUtc;
    public String UserName;
    public String Email;
    
}
