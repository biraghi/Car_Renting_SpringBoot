package com.example.Car_Renting_SpringBoot.controller;

import com.example.Car_Renting_SpringBoot.entity.User;
import com.example.Car_Renting_SpringBoot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllCars(){
        List<User> list = userService.getAll();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User user = userService.getById(id);
        if(user == null){
            String ErrMsg = String.format("User not found with id %s", id);
            logger.warn(ErrMsg);
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
    }

    @GetMapping("/getUsername/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        User user = userService.getByUsername(username);
        if(user == null){
            String ErrMsg = String.format("User not found with username %s", username);
            logger.warn(ErrMsg);
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        User newUser = userService.add(user);
        if(newUser == null){
            String ErrMsg = "Error";
            logger.warn(ErrMsg);
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int id){
        User newUser = userService.update(user, id);
        if(newUser == null){
            String ErrMsg = String.format("User not found with id %s or Bad Request", id);
            logger.warn(ErrMsg);
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<User> deleteAllUsers(){
        userService.deleteAll();
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<User> deleteUserbyId(@PathVariable int id){
        boolean del = userService.deleteById(id);
        if (!del){
            String ErrMsg = String.format("User not found with id %s", id);
            logger.warn(ErrMsg);
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<User>(HttpStatus.OK);
        }
    }

}
