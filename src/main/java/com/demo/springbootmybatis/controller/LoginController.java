package com.demo.springbootmybatis.controller;

import com.demo.springbootmybatis.Mapper.EmployeeMapper;
import com.demo.springbootmybatis.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    EmployeeMapper employeeMapper;

    @PostMapping("/user/login")
    public String login(@RequestParam("empName") Integer empName,
                        @RequestParam("empPassword") String empPassword,
                        Map<String, Object> map, HttpSession session) {
        Employee employee = employeeMapper.getEmpById(empName);
        if(employee != null && empPassword.equals(employee.getLastName())) {
            session.setAttribute("loginUser", empName);
            return "redirect:/main.html";
        }else {
            map.put("msg", "用户密码错误");
            return "login";
        }
    }
}
