package com.example.L10springjpademo;

import com.example.L10springjpademo.entity.Branch;
import com.example.L10springjpademo.entity.Employee;
import com.example.L10springjpademo.exception.EmployeeAppException;
import com.example.L10springjpademo.repo.IAddressRepo;
import com.example.L10springjpademo.repo.IBranchRepo;
import com.example.L10springjpademo.repo.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeRepo employeeRepo;

    @Autowired
    private IAddressRepo addressRepo;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private IBranchRepo branchRepo;


//    public Employee createEmployee(Employee employee)  {
//        employeeRepo.save(employee);
//    return employee;
//    }


    @Transactional(rollbackOn = {EmployeeAppException.class},dontRollbackOn = {})
    public Employee createEmployee(Employee employee) throws EmployeeAppException {
        addressRepo.save(employee.getAddress());
        employeeRepo.save(employee);
        Branch branch = new Branch();
        branch.setName("Test Branch");
        branchRepo.save(branch);
        employee.setBranch(branch);
        employee.setName("Before detach");
//        entityManager.flush();
//        entityManager.detach(employee);
//        employee.setName("After detach");
        if(employee.getAddress().getCity().equals("Kanpur")){
            throw new EmployeeAppException();
        }
        return employee;
    }


    public Employee findByName(String name){
       return null;
    }

}
