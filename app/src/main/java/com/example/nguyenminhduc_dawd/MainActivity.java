package com.example.nguyenminhduc_dawd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Employee,Des,Salary ;
    Button btAdd,btUpdate,btDelete;

    RecyclerView rvUser;
    AppDataBase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     db = AppDataBase.getAppDataBase(this);
     Employee = findViewById(R.id.Employee);
     Des = findViewById(R.id.Des);
     Salary = findViewById(R.id.Salary);
     btAdd = findViewById(R.id.btAdd);
     btUpdate = findViewById(R.id.btUpdate);
     btDelete = findViewById(R.id.btDelete);
     btAdd.setOnClickListener(this);
     btUpdate.setOnClickListener(this);
     btDelete.setOnClickListener(this);




}


    private void onAdd() {
        if(!validate()){
            return;
        }
        User user =new User();
        user.employee =Employee.getText().toString();
        user.designation=Des.getText().toString();
        user.salary=Salary.getText().toString();
        long id =db.userDao().insertUser(user);
        if (id>0){
            Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
        }
        getAllEmployee();

    }
    private void getAllEmployee() {
        db = AppDataBase.getAppDataBase(this);
        List<User> list = db.userDao().getAllEmployee();
        for (User user : list) {
            Log.d("TAG", "id: "+user.id + " - Name: " +user.employee);
        }
        UserAdapter adapter = new UserAdapter(this,list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvUser = findViewById(R.id.rvUser);
        rvUser.setLayoutManager(layoutManager);
        rvUser.setAdapter(adapter);
    }

    private boolean validate() {
        String mes = null;
        if(Employee.getText().toString().trim().isEmpty()){
            mes =" chua nhap username";
        }else
        if (Des.getText().toString().trim().isEmpty()){
            mes= "Chua nhap gioi thieu";
        }else
        if(Salary.getText().toString().trim().isEmpty()){
            mes = "ban phai  nhap gia";
        }
        if(mes!= null){
            Toast.makeText(this, mes , Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btAdd:
                onAdd();
                break;
            default:
                break;
        }
    }
}