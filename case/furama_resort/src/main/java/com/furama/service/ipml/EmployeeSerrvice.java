package com.furama.service.ipml;

import com.furama.model.AppRole;
import com.furama.model.AppUser;
import com.furama.model.Employee;
import com.furama.repository.IEmployeeRepository;
import com.furama.service.IEmployeeService;
import com.furama.service.createRoleService.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSerrvice implements IEmployeeService {

    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    IEmployeeRepository iEmployeeRepository;


    @Override
    public Page<Employee> findAllEmployees(String name, String address, String phone, Pageable pageable) {
        return iEmployeeRepository.findByEmployeeNameContainingAndAndEmployeeAddressContainingAndAndEmployeePhoneContaining(name, address, phone, pageable);
    }

    @Override
    public Page<Employee> findAllAndSerchEmployees(String name, String address, String phone, String idDivision, Pageable pageable) {
        return iEmployeeRepository.findByAllAndSearch("%" + name + "%", "%" + address + "%", "%" + phone + "%", idDivision, pageable);
    }

    @Override
    public Page<Employee> findEmployees(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }


    @Override
    public void save(Employee employee) {

        //create user
        AppUser employeeUser = new AppUser();
        this.userRoleService.saveUser(employee, employeeUser);//
        //create role
        // -- retriev all role;
        AppRole userRole = this.userRoleService.findAppRole(2);
        AppRole adminRole = this.userRoleService.findAppRole(1);

        this.userRoleService.saveUserRole(employee, employeeUser, userRole, adminRole);//

        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return iEmployeeRepository.findById(id).get();
    }

    @Override
    public void update(Employee employee) {

        AppUser employeeUser = new AppUser();
        this.userRoleService.saveUser(employee, employeeUser);
        // create role
        // -- retriev all role;
        AppRole userRole = this.userRoleService.findAppRole(2);
        AppRole adminRole = this.userRoleService.findAppRole(1);
        this.userRoleService.saveUserRole(employee, employeeUser, userRole, adminRole);

        employee.setFlag(1);
        iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(Long id ) {

        iEmployeeRepository.deleteEmployee(id);

    }
}
