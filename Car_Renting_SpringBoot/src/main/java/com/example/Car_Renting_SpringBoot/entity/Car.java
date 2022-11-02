package com.example.Car_Renting_SpringBoot.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="manufacturer")
    @NotBlank(message = "{NotBlank.Car.manufacturer.validation}")
    private String manufacturer;

    @Column(name="model")
    @NotBlank(message = "{NotBlank.Car.model.validation}")
    private String model;

    @Column(name="year_registration")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "{NotNull.Car.yearRegistration.validation}")
    @Past
    private LocalDate yearRegistration;

    @Column(name="license_plate")
    @NotBlank(message = "{NotBlank.Car.licensePlate.validation}")
    private String licensePlate;

    @Column(name="type_name")
    @NotBlank(message = "{NotBlank.Car.typeName.validation}")
    private String typeName;

    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List<Booking> bookings;

    public Car(){}

    public Car(String manufacturer, String model, LocalDate yearRegistration, String licensePlate, String typeName) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearRegistration = yearRegistration;
        this.licensePlate = licensePlate;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){this.id = id;}

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getYearRegistration() {
        return yearRegistration;
    }

    public void setYearRegistration(LocalDate yearRegistration) {
        this.yearRegistration = yearRegistration;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", yearRegistration='" + yearRegistration + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
