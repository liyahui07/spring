package com.imooc.oa.biz;

import com.imooc.oa.entity.Department;

import java.util.List;

public interface DepartmentBiz {
    void add(Department department);
    void edit(Department department);
    void remove(String sn);
    Department getByDepart(String sn);
    List<Department> getAllDepart();

}
