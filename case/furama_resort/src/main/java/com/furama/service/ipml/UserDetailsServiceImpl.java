package com.furama.service.ipml;


import com.furama.model.AppRole;
import com.furama.model.AppUser;
import com.furama.model.Employee;
import com.furama.model.UserRole;
import com.furama.repository.createRole.AppRoleRepository;
import com.furama.repository.createRole.AppUserRepository;
import com.furama.repository.createRole.UserRoleRepository;
import com.furama.service.createRoleService.UserRoleService;
import com.furama.util.EncrytedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserRoleService {

    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.appUserRepository.findByUserName(userName);

        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<UserRole> roleNames = this.userRoleRepository.findByAppUser(appUser);

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            for (UserRole userRole : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getAppRole().getRoleName());
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
                appUser.getEncrytedPassword(), grantList);

        return userDetails;
    }


    @Override
    public void saveUserRole(Employee employee, AppUser employeeUser, AppRole userRole, AppRole adminRole) {
        // quản lý


        if (employee.getIdPositon().getPositionId() == 1) {
            UserRole employeeRoleAdmin = new UserRole();
            employeeRoleAdmin.setAppRole(adminRole);
            employeeRoleAdmin.setAppUser(employeeUser);
//            adminRole.setRoleName(employee.getEmployeeEmail());
            this.userRoleRepository.save(employeeRoleAdmin);
        }

        // nhan vien
        UserRole employeeRoleUser = new UserRole();
        employeeRoleUser.setAppRole(userRole);
        employeeRoleUser.setAppUser(employeeUser);
        this.userRoleRepository.save(employeeRoleUser);
    }

    @Override
    public void saveUser(Employee employee, AppUser employeeUser) {

        // email vaf pass

        employeeUser.setUserName(employee.getEmployeeEmail());
        String pass = EncrytedPasswordUtils.encrytePassword("123");
        employeeUser.setEncrytedPassword(pass);

        employee.setUserName(employeeUser);

        this.appUserRepository.save(employeeUser);

    }

    @Override
    public void saveRole(AppRole appRole) {

    }

    @Override
    public AppRole findAppRole(int i) {
        return this.appRoleRepository.findById((long) i).orElse(null);
    }
}