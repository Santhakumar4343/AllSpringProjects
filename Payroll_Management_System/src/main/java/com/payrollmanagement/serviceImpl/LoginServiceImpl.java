package com.payrollmanagement.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payrollmanagement.entity.Login;
import com.payrollmanagement.repository.LoginRepository;
import com.payrollmanagement.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public boolean login(String officialEmail, String password) {
        Login employee = loginRepository.findByOfficialEmail(officialEmail);
        if (employee != null && employee.getOfficialMailPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean changePassword(String officialEmail, String oldPassword, String newPassword) {
        Login employee = loginRepository.findByOfficialEmail(officialEmail);
        if (employee != null && employee.getOfficialMailPassword().equals(oldPassword)) {
            employee.setOfficialMailPassword(newPassword);
            loginRepository.save(employee);
            return true;
        }
        return false;
    }

    @Override
    public void registerEmployee(Login employee) {
    	loginRepository.save(employee);
    }

    @Override
    public List<Login> getLogins() {
        return loginRepository.findAll();
    }
}