package com.imooc.oa.controller;

import com.imooc.oa.biz.DepartmentBiz;
import com.imooc.oa.biz.EmployeeBiz;
import com.imooc.oa.entity.Employee;
import com.imooc.oa.global.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeBiz employeeBiz;

    @Autowired
    DepartmentBiz departmentBiz;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",employeeBiz.getAllEmp());
        //暂时没用到
//        map.put("dList",departmentBiz.getAllDepart());
        return "employee_list";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("employee",new Employee());
        map.put("dList",departmentBiz.getAllDepart());
        map.put("post", Content.getPost());
        return "employee_add";
    }

    @RequestMapping("/add")
    public String add(Employee employee){
        employeeBiz.add(employee);
        return "redirect:list";
    }

    @RequestMapping("/to_update")
    public String toUpdate(String sn,Map<String,Object> map){
        map.put("employee",employeeBiz.getByDepart(sn));
        map.put("dList",departmentBiz.getAllDepart());
        map.put("post",Content.getPost());
        return "employee_update";
    }

    @RequestMapping("/update")
    public String update(Employee employee){
        employeeBiz.edit(employee);
        return "redirect:list";
    }

    @RequestMapping("/remove")
    public String remove(String sn){
        employeeBiz.remove(sn);
        return "redirect:list";
    }


}
