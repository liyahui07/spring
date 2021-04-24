package com.imooc.oa.controller;

import com.imooc.oa.biz.LoginBiz;
import com.imooc.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    LoginBiz loginBiz;
    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session,String sn,String password){
        Employee login = loginBiz.login(sn, password);
        if (login != null){
            session.setAttribute("employee",login);
            return "self";
        }
        return "redirect:to_login";
    }

    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password";
    }

    @RequestMapping("/changePassword")
    public String changePassword(HttpSession session,String old,String new1,String new2){
        Employee employee = (Employee)session.getAttribute("employee");
        if (employee.getPassword().equals(old)){
            if (new1.equals(new2)){
                employee.setPassword(new1);
                loginBiz.changePassword(employee);
            }else {
                return "redirect:to_change_password";
            }
        }else {
            return "redirect:to_change_password";
        }
        return "redirect:to_login";
    }

    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.setAttribute("employee",null);
        return "redirect:to_login";
    }



}
