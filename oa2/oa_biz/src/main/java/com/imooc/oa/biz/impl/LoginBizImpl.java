package com.imooc.oa.biz.impl;

import com.imooc.oa.biz.LoginBiz;
import com.imooc.oa.dao.EmployeeDao;
import com.imooc.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginBizImpl implements LoginBiz {

    @Autowired
    EmployeeDao employeeDao;

    public Employee login(String sn, String password) {
        Employee employee = employeeDao.selectOne(sn);

        if (employee.getPassword().equals(password)){
            return employee;
        }

        return null;
    }

    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
