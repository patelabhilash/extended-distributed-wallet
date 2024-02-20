package com.supabaseconnector.artifact2.model;

import java.util.List;

import com.supabaseconnector.artifact2.entity.jour.Employee;
import com.supabaseconnector.artifact2.entity.jour.Route;
import com.supabaseconnector.artifact2.entity.jour.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ERVHolder {
    
    private List<Employee> employees;
    private List<Route> routes;
    private List<Vehicle> vehicles;

}
