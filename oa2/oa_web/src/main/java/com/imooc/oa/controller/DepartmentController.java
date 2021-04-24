package com.imooc.oa.controller;

import com.imooc.oa.biz.DepartmentBiz;
import com.imooc.oa.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentBiz departmentBiz;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        List<Department> allDepart = departmentBiz.getAllDepart();
//        for (Department d :
//                allDepart) {
//            System.out.println(d);
//        }
//        System.out.println("********");
        map.put("list",allDepart);
        return "department_list";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("department",new Department());
        return "department_add";
    }

    @RequestMapping("/add")
    public String add(Department department){
        departmentBiz.add(department);
        return "redirect:list";
    }

    @RequestMapping("/to_update")
    public String toUpdate(String sn,Map<String,Object> map){
        map.put("department",departmentBiz.getByDepart(sn));
        return "department_update";
    }

    @RequestMapping("/update")
    public String update(Department department){
        departmentBiz.edit(department);
        return "redirect:list";
    }

    @RequestMapping("/remove")
    public String remove(String sn){
        departmentBiz.remove(sn);
        return "redirect:list";
    }

}
