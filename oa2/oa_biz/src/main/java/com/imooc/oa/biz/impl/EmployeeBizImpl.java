package com.imooc.oa.biz.impl;

import com.imooc.oa.biz.EmployeeBiz;
import com.imooc.oa.dao.EmployeeDao;
import com.imooc.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeBizImpl implements EmployeeBiz {
    
    @Autowired
    EmployeeDao employeeDao;
    
    public void add(Employee employee) {
        employee.setPassword("123456");
        employeeDao.insert(employee);
    }

    public void edit(Employee employee) {
        employeeDao.update(employee);
    }

    public void remove(String sn) {
        employeeDao.delete(sn);
    }

    public Employee getByDepart(String sn) {
        return employeeDao.selectOne(sn);
    }

    public List<Employee> getAllEmp() {
        return employeeDao.selectAll();
    }
}
