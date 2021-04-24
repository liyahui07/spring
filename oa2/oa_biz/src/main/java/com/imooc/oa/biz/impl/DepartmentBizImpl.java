package com.imooc.oa.biz.impl;

import com.imooc.oa.biz.DepartmentBiz;
import com.imooc.oa.dao.DepartmentDao;
import com.imooc.oa.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentBizImpl implements DepartmentBiz {

    @Autowired
    DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public void remove(String sn) {
        departmentDao.delete(sn);
    }

    public Department getByDepart(String sn) {
        return departmentDao.selectOne(sn);
    }

    public List<Department> getAllDepart() {
        return departmentDao.selectAll();
    }
}
