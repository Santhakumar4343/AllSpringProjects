package com.payrollmanagement.service;



import java.util.List;
import com.payrollmanagement.entity.Login;

public interface LoginService {
    boolean login(String officialEmail, String password);

    boolean changePassword(String officialEmail, String oldPassword, String newPassword);

    void registerEmployee(Login employee);

    List<Login> getLogins();
}

    
    
    
    //get the 2 columns
 /*   
    public <MyCustomDTO> MyCustomDTO getColumnsById(int id) {
        Optional<Object[]> result = employeeRepository.findById(id);
        if (result.isPresent()) {
            Object[] columns = result.get();
            String column1Value = (String) columns[0];
            String column2Value = (String) columns[1];
            // Create and return MyCustomDTO object
            return new MyCustomDTO(column1Value, column2Value);
        } else {
            throw new NotFoundException("Data not found for ID: " + id);
        }
 	*/