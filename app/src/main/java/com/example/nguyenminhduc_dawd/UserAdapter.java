package com.example.nguyenminhduc_dawd;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<User> lisUser;


    public UserAdapter(Activity activity, List<User> listEmployee) {
        this.activity = activity;
        this.lisUser = listEmployee;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_user, parent,false);
        EmployeeHolder holder = new EmployeeHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmployeeHolder vh = (EmployeeHolder) holder;
        User user = lisUser.get(position);
        vh.Employee.setText(user.employee);
        vh.Des.setText(user.designation);
        vh.Salary.setText(user.salary);
    }

    @Override
    public int getItemCount() {
        return lisUser.size();
    }

    public class EmployeeHolder extends RecyclerView.ViewHolder {
        TextView Employee, Des, Salary;

        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            Employee = itemView.findViewById(R.id.Employee);
            Des = itemView.findViewById(R.id.Designation);
            Salary = itemView.findViewById(R.id.Salary);
        }
    }
}