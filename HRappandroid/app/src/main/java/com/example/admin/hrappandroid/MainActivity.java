package com.example.admin.hrappandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText ne1,ae2,se3,be4,he5,re6,ce7,pe8,me9;
    Button lb4,sb2,ab1,ub3,cb5,bb6,cb9;
     private String name,age,salary,bonus,hours,rate,plate,make,college;
    int birthyear;
    Vehicle v;
    Fulltime f;
    Parttime p;
    Intern i;
    ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
    String result =" ";
    int earn = 0;
    int totalpayroll =0;
    TextView tt10;

    Employee CurrentEmployee  = new Employee();


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ne1 = (EditText) findViewById(R.id.ne1);
        ae2 = (EditText) findViewById(R.id.ae2);
        se3 = (EditText) findViewById(R.id.se3);
        be4 = (EditText) findViewById(R.id.be4);
        he5 = (EditText) findViewById(R.id.he5);
        re6 = (EditText) findViewById(R.id.re6);
        ce7 = (EditText) findViewById(R.id.ce7);
        pe8 = (EditText) findViewById(R.id.pe8);
        me9 = (EditText) findViewById(R.id.me9);

        tt10 = (TextView) findViewById(R.id.tt10);


        lb4 = (Button) findViewById(R.id.lb4);
        sb2 = (Button) findViewById(R.id.sb2);
        ab1 = (Button) findViewById(R.id.ab1);
        ub3 = (Button) findViewById(R.id.ub3);
        cb5 = (Button) findViewById(R.id.cb5);
        bb6 = (Button) findViewById(R.id.bb6);

        ab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = ne1.getText().toString();


                age = ae2.getText().toString();
                salary = se3.getText().toString();

                bonus = be4.getText().toString();
                hours = he5.getText().toString();
                rate = re6.getText().toString();
                plate = pe8.getText().toString();
                make = me9.getText().toString();
                college = ce7.getText().toString();

                if (!salary.equals("") && !bonus.equals("")) {
                    if (!plate.equals("") && !make.equals("")) {
                        v = new Vehicle(plate, make);

                    } else {
                        v = null;
                    }

                    f = new Fulltime(Integer.parseInt(salary), Integer.parseInt(bonus), name, Integer.parseInt(age), v);
                    arrEmployee.add(f);
                    Toast.makeText(getBaseContext(), "Full time Employee Add", Toast.LENGTH_LONG).show();
                    cleardata();
                } else if (!hours.equals("") && !rate.equals("")) {
                    Log.d("hjh", "hi");
                    if (!plate.equals("") && !make.equals("")) {
                        v = new Vehicle(plate, make);
                    } else {
                        v = null;
                    }
                    p = new Parttime(Integer.parseInt(hours), Integer.parseInt(rate), name, Integer.parseInt(age), v);
                    arrEmployee.add(p);
                    Toast.makeText(getBaseContext(), "PartTime Employee add", Toast.LENGTH_LONG).show();
                    cleardata();
                } else if (!college.equals("")) {
                    if (!plate.equals("") && !make.equals("")) {
                        v = new Vehicle(plate, make);

                    } else {
                        v = null;
                    }
                    i = new Intern(college, name, Integer.parseInt(age), v);
                    arrEmployee.add(i);
                    Toast.makeText(getBaseContext(), "Intern Add", Toast.LENGTH_LONG).show();
                }

            }
        });

        lb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = "";
                for (int i = 0; i < arrEmployee.size(); i++) {
                    earn = arrEmployee.get(i).calcEarnings();

                    result += "Name:" + arrEmployee.get(i).getName() + "\n" + "Age:" + arrEmployee.get(i).getAge() + "\n" + "Earning:" +
                            earn + "\n" ;
                    if(arrEmployee.get(i).getVehicleobject()!= null){
                        result += "Vehicle Details:\n "+"Plate Number\n"+arrEmployee.get(i).getVehicleobject().getPlatNumber()+"\n"
                      +"Make:\n"+  arrEmployee.get(i).getVehicleobject().platNumber+"\n";
                    }
                    else{
                        result += "No  vehicle data\n";
                    }


                }
                tt10.setText(result);
            }

        });

        cb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < arrEmployee.size(); i++) {
                    earn = arrEmployee.get(i).calcEarnings();


                    totalpayroll = totalpayroll + earn;

                }
                Toast.makeText(getBaseContext(), "Total PayRoll:" + totalpayroll, Toast.LENGTH_LONG).show();
            }
        });


        bb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < arrEmployee.size(); i++) {

                    birthyear = arrEmployee.get(i).CalBirthYear();

                }
                Toast.makeText(getBaseContext(), "Birth Year:" + birthyear, Toast.LENGTH_LONG).show();
            }

        });

        sb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < arrEmployee.size(); i++) {
                    //  Log.d("name value:",name);
                    Log.d("name::", arrEmployee.get(i).getName());
                    String name1 = ne1.getText().toString();
                    Log.d("name1:", name1);
                    if (name1.equals(arrEmployee.get(i).getName())) {
                        CurrentEmployee = arrEmployee.get(i);
                        Log.d("hi", "hiral");
                        Search(CurrentEmployee);
                        Log.d("ff", "hiral1");
                        // break;
                    } else {
                        Toast.makeText(getBaseContext(), "No Data", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        ub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CurrentEmployee instanceof Fulltime) {
                    CurrentEmployee.setName(ne1.getText().toString());
                    CurrentEmployee.setAge(Integer.parseInt(ae2.getText().toString()));
                    ((Fulltime) CurrentEmployee).setSalary(Integer.parseInt(se3.getText().toString()));
                    ((Fulltime) CurrentEmployee).setBonus(Integer.parseInt(be4.getText().toString()));
                }
                if (CurrentEmployee instanceof Parttime) {
                    CurrentEmployee.setName(ne1.getText().toString());
                    CurrentEmployee.setAge(Integer.parseInt(ae2.getText().toString()));
                    ((Parttime) CurrentEmployee).setHoursWorked(Integer.parseInt(he5.getText().toString()));
                    ((Parttime) CurrentEmployee).setRate(Integer.parseInt(re6.getText().toString()));

                }

                if (CurrentEmployee instanceof Intern) {
                    CurrentEmployee.setName(ne1.getText().toString());
                    CurrentEmployee.setAge(Integer.parseInt(ae2.getText().toString()));
                    ((Intern) CurrentEmployee).setCollegeName(ce7.getText().toString());
                }
                if (CurrentEmployee.getVehicleobject() != null) {
                    CurrentEmployee.getVehicleobject().setPlatNumber(pe8.getText().toString());
                    CurrentEmployee.getVehicleobject().setMake(me9.getText().toString());
                }
            }
        });
    }

    private void cleardata() {
        ne1.setText("");
        ae2.setText("");
        se3.setText("");
        be4.setText("");
        pe8.setText("");
        he5.setText("");
        re6.setText("");
        ce7.setText("");
        me9.setText("");
    }


    private void Search(Employee e) {

        if( e instanceof  Fulltime){

            ne1.setText(e.getName().toString());
            ae2.setText(String.valueOf(e.getAge()));
            se3.setText(String.valueOf(((Fulltime) e).getSalary()));
            be4.setText(String.valueOf(((Fulltime) e).getBonus()));

        }
        if(e instanceof Parttime){
            ne1.setText(e.getName().toString());
            ae2.setText(String.valueOf(e.getAge()));
            he5.setText(String.valueOf(((Parttime) e).getHoursWorked()));
            re6.setText(String.valueOf(e.getAge()));
        }

        if(e instanceof Intern){
            ne1.setText(e.getName().toString());
            ae2.setText(String.valueOf(e.getAge()));
            ce7.setText(String.valueOf(((Intern) e).getCollegeName()));
        }

        if( e.getVehicleobject() != null){
            pe8.setText(e.getVehicleobject().getPlatNumber());
            me9.setText(e.getVehicleobject().getMake());
        }





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case R.id.action_settings:
              cleardata();
                return true;


        }

        return super.onOptionsItemSelected(item);
    }
}
