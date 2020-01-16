package com.demo.springbootmybatis.controller;

import com.demo.springbootmybatis.Mapper.EmployeeMapper;
import com.demo.springbootmybatis.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class EmployeeController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/empmessage")
    public String empSelect(HttpSession session, Model model) {
        Integer id = (Integer) session.getAttribute("loginEmp");
        Employee employee = employeeMapper.getEmpById(id);
        model.addAttribute("emp", employee);
        return "emp/list";
    }
}
