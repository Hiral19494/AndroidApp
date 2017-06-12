package com.example.admin.hrappandroid;

/**
 * Created by Admin on 23-11-2016.
 */
public class Vehicle implements IDisplayable{

    public String platNumber;
    public  String make;

    public Vehicle() {
        platNumber ="";
        make = "";

    }

    public Vehicle(String platNumber, String make) {
        this.platNumber = platNumber;
        this.make = make;
    }

    public String getPlatNumber() {
        return platNumber;
    }

    public void setPlatNumber(String platNumber) {
        this.platNumber = platNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String displaydata() {
        System.out.println("Plate Number:"+platNumber);
        System.out.println("Make:"+make);//To change body of generated methods, choose Tools | Templates.

        return null;
    }

}

