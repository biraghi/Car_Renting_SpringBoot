package com.example.Car_Renting_SpringBoot.entity;



import com.example.Car_Renting_SpringBoot.validation.ValidPassword;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "username")
    @NotBlank(message = "{NotBlank.User.username.validation}")
    private String username;

    @Column(name="password")
    @ValidPassword
    private String password;

    @Column(name="firstname")
    @NotBlank(message = "{NotBlank.User.firstname.validation}")
    private String firstname;

    @Column(name = "lastname")
    @NotBlank(message = "{NotBlank.User.lastname.validation}")
    private String lastname;

    @Column(name = "birth_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "{NotNull.User.birthDate.validation}")
    @Past
    private LocalDate birthDate;

    @Column(name = "admin")
    private boolean admin;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;



    public User(){}


    public User(String username, String password, String firstname, String lastname, LocalDate birthDate, boolean admin) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.admin = admin;
    }

    public void setId(int id){this.id = id;}
    public int getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDate=" + birthDate +
                ", admin='" + admin + '\'' +
                '}';
    }
}
