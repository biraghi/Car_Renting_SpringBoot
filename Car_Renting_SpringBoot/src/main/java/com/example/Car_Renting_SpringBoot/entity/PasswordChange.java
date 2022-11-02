package com.example.Car_Renting_SpringBoot.entity;

import com.example.Car_Renting_SpringBoot.validation.ValidPassword;

import javax.validation.constraints.NotBlank;

public class PasswordChange {
    @NotBlank(message = "{NotBlank.User.password.validation}")
    private String oldPassword;

    @ValidPassword
    private String newPassword;

    public PasswordChange(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public PasswordChange() {
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
