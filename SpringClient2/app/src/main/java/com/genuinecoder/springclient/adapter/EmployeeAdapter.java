package com.genuinecoder.springclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.genuinecoder.springclient.R;
import com.genuinecoder.springclient.model.Employee;
import com.genuinecoder.springclient.reotrfit.EmployeeApi;
import com.genuinecoder.springclient.reotrfit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeHolder> {

  private List<Employee> employeeList;
  private Context context;

  // Constructor updated to take Context as a parameter
  public EmployeeAdapter(Context context, List<Employee> employeeList) {
    this.context = context;
    this.employeeList = employeeList;
  }

  @NonNull
  @Override
  public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_employee_item, parent, false);
    return new EmployeeHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
    Employee employee = employeeList.get(position);
    holder.name.setText(employee.getName());
    holder.location.setText(employee.getLocation());
    holder.branch.setText(employee.getBranch());

    // Assuming you have a delete button in your EmployeeHolder class
    holder.deletebutton.setOnClickListener(view -> {
      // First, remove the item from the list and notify the adapter
      employeeList.remove(position);
      notifyItemRemoved(position);
      deleteEmployee(employee.getId());
    });
  }

  private void deleteEmployee(int employeeId) {
    RetrofitService retrofitService = new RetrofitService();
    EmployeeApi employeeApi = retrofitService.getRetrofit().create(EmployeeApi.class);
    employeeApi.deleteEmployee(employeeId).enqueue(new Callback<Void>() {
      @Override
      public void onResponse(Call<Void> call, Response<Void> response) {
        if (response.isSuccessful()) {
          Toast.makeText(context, "Employee deleted", Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(context, "Failed to delete employee", Toast.LENGTH_SHORT).show();
        }
      }

      @Override
      public void onFailure(Call<Void> call, Throwable t) {
        Toast.makeText(context, "Failed to delete employee", Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override
  public int getItemCount() {
    return employeeList.size();
  }
}
