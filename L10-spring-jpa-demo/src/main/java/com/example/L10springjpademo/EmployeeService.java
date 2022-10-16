package com.example.L10springjpademo;

import com.example.L10springjpademo.entity.Branch;
import com.example.L10springjpademo.entity.Employee;
import com.example.L10springjpademo.exception.EmployeeAppException;
import com.example.L10springjpademo.repo.IAddressRepo;
import com.example.L10springjpademo.repo.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeRepo employeeRepo;

    @Autowired
    private IAddressRepo addressRepo;



//    public Employee createEmployee(Employee employee)  {
//        employeeRepo.save(employee);
//    return employee;
//    }


    @Transactional(rollbackOn = {EmployeeAppException.class},dontRollbackOn = {})
    public Employee createEmployee(Employee employee) throws EmployeeAppException {
        addressRepo.save(employee.getAddress());
        employeeRepo.save(employee);
        if(employee.getAddress().getCity().equals("Kanpur")){
            throw new EmployeeAppException();
        }
        return employee;
    }


    public Employee findByName(String name){
       return null;
    }

}
