package com.example.admin.hrappandroid;

/**
 * Created by Admin on 24-11-2016.
 */

public class Intern extends Employee {
    public Intern(String collegeName, String name, int age, Vehicle vehicleobject) {
        super(name, age, vehicleobject);
        this.collegeName = collegeName;
    }

    public  String collegeName;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Intern() {

        super();
        collegeName ="";
    }

    public Intern(String collegeName, String name, int age) {
        super(name, age);
        this.collegeName = collegeName;
    }


    @Override
    public String displaydata(){
        System.out.println("Intern");
        super.displaydata();
        System.out.println("College Name:"+collegeName);

        return null;
    }

}
