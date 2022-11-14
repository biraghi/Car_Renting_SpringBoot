package com.example.Car_Renting_SpringBoot.service;

import com.example.Car_Renting_SpringBoot.entity.User;
import com.example.Car_Renting_SpringBoot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        if(id != 0 && userRepository.findById(id).isPresent()){
            return userRepository.findById(id).get();
        }
        else{
            return null;
        }
    }

    @Override
    public User getByUsername(String username) {
        if(username != null && userRepository.findByUsername(username).isPresent()){
            return userRepository.findByUsername(username).get();
        }
        else{
            return null;
        }
    }

    @Override
    public User add(User user) {
        if(user != null && user.getId() == 0){
            return userRepository.save(user);
        }
        else{
            return null;
        }
    }

    @Override
    public User update(User user, int id) {
        if(user != null && userRepository.findById(id).isPresent()){
            User oldUser = userRepository.findById(id).get();
            oldUser.setUsername(user.getUsername());
            oldUser.setFirstname(user.getFirstname());
            oldUser.setLastname(user.getLastname());
            oldUser.setBirthDate(user.getBirthDate());
            oldUser.setAdmin(user.getAdmin());
            return userRepository.save(oldUser);
        }
        else{
            return null;
        }
    }

    @Override
    public boolean deleteAll() {
        userRepository.deleteAll();
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        if(id != 0 && userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }
}
