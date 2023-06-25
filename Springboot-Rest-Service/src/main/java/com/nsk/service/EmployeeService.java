package com.nsk.service;
import com.nsk.entity.Employee;
import java.util.*;

public interface EmployeeService {
public Employee saveEmp(Employee emp);
public void deleteEmp(int empid);
public Employee getEmp(int empid );
public List<Employee> getAllEmp();
public Employee updateEmp(Employee emp,int empid);
}
