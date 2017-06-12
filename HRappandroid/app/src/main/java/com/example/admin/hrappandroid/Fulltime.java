package com.example.admin.hrappandroid;

/**
 * Created by Admin on 24-11-2016.
 */

public class Fulltime extends Employee {


    public int salary;
    public int bonus;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Fulltime(int salary, int bonus, String name, int age, Vehicle vehicleobject) {
        super(name, age, vehicleobject);
        this.salary = salary;
        this.bonus = bonus;
    }

    public Fulltime(int salary, int bonus, String name, int age) {
        super(name, age);
        this.salary = salary;
        this.bonus = bonus;
    }

    public Fulltime() {
        super();
        salary=0;
        bonus=0;

    }

    /**
     *
     */
    @Override
    public int calcEarnings(){
        return (salary + bonus);

    }

    /**
     *
     * @return
     */
    @Override
    public String displaydata(){
        System.out.println("FullTime");
        super.displaydata();
        System.out.println("Salary:"+salary);
        System.out.println("bonus"+bonus);
        return null;
    }


}
