package com.genuinecoder.springclient.reotrfit;

import com.genuinecoder.springclient.model.Employee;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EmployeeApi {

  @GET("/employee/get-all")
  Call<List<Employee>> getAllEmployees();

  @POST("/employee/save")
  Call<Employee> save(@Body Employee employee);

  @DELETE("/employee/delete/{id}")
  Call<Void> deleteEmployee(@Path("id") int id);


}
