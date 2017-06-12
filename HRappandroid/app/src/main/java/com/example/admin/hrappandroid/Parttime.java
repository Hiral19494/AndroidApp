package com.example.admin.hrappandroid;

/**
 * Created by Admin on 24-11-2016.
 */

public class Parttime extends Employee {

    public int hoursWorked;
    public int rate;

    public Parttime(int hoursWorked, int rate, String name, int age, Vehicle vehicleobject) {
        super(name, age, vehicleobject);
        this.hoursWorked = hoursWorked;
        this.rate = rate;
    }


    public Parttime() {
        super();
        hoursWorked =0;
        rate =0;

    }

    public Parttime(int hoursWorked, int rate, String name, int age) {
        super(name, age);
        this.hoursWorked = hoursWorked;
        this.rate = rate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public int calcEarnings(){
        return (hoursWorked * rate);

    }

    @Override
    public String displaydata(){
        System.out.println("PartTime");
        super.displaydata();
        System.out.println("Hours:"+hoursWorked);
        System.out.println("Rate"+rate);

        return null;
    }


}
