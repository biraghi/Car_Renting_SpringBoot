package com.example.Car_Renting_SpringBoot.service;

import com.example.Car_Renting_SpringBoot.entity.User;

import java.util.List;

public interface UserServiceInterface {
    public List<User> getAll();
    public User getById(int id);
    public User getByUsername(String username);
    public User add(User user);
    public User update(User user, int id);
    public boolean deleteAll();
    public boolean deleteById(int id);
}
