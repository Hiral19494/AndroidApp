package com.example.admin.hrappandroid;

/**
 * Created by Admin on 23-11-2016.
 */

public class Employee implements IDisplayable {
    String name;
    public int age;

    public void setVehicleobject(Vehicle vehicleobject) {
        this.vehicleobject = vehicleobject;
    }

    public Vehicle vehicleobject;

    public Vehicle getVehicleobject() {
        return vehicleobject;
    }


    public Employee() {
        name = "";
        age = 0;
    }

    public Employee(String name, int age, Vehicle vehicleobject) {
        this.name = name;
        this.age = age;
        this.vehicleobject = vehicleobject;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int CalBirthYear() {
        return (2016 - age);

    }

    public int calcEarnings() {
        return 1000;
    }

    public String displaydata() {
        System.out.println("Name:" + getName());
        System.out.println("Age:" + getAge());
        if (vehicleobject != null) {
            vehicleobject.displaydata();
        } else {
            System.out.println("Employee has no vehicle");
        }
        return null;
    }
}
