package com.furama.service.createRoleService;

import com.furama.model.AppRole;
import com.furama.model.AppUser;
import com.furama.model.Employee;
import com.furama.model.UserRole;

public interface UserRoleService {
    void saveUserRole(Employee employee,AppUser appUser ,AppRole userRole, AppRole adminRole);

    void saveUser(Employee employee, AppUser appUser);

    void saveRole(AppRole appRole);

    AppRole findAppRole(int i);
}
