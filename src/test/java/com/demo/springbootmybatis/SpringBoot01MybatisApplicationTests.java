package com.demo.springbootmybatis;

import com.demo.springbootmybatis.Mapper.DepartmentMapper;
import com.demo.springbootmybatis.Mapper.EmployeeMapper;
import com.demo.springbootmybatis.bean.Department;
import com.demo.springbootmybatis.bean.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringBoot01MybatisApplicationTests {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    EmployeeMapper employeeMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    void contextLoads() {
        /*Employee employee = employeeMapper.getEmpAndDept(1);
        System.out.println(employee);
        System.out.println(employee.getDepartment());*/

        /*Employee employee = new Employee(null, "sary", "sary@demo.com", "0", new Department(1, null));
        Boolean b = employeeMapper.insertEmpById(employee);
        System.out.println(b);*/

        /*Map<Integer, Employee> emps = employeeMapper.getEmpsByDeptId(1);
        for (Map.Entry<Integer, Employee> emp : emps.entrySet()) {
            System.out.println(emp.getKey()+":"+emp.getValue());
        }*/

        List<Integer> ids = new ArrayList<>();
        ids.add(1); ids.add(10); ids.add(9);
        List<Employee> emps = employeeMapper.getEmpsByIdForearch(ids);
        if(emps.isEmpty()) System.out.println("The result set is empty.");
        for (Employee emp:emps) {
            System.out.println(emp);
        }
    }

    @Test
    void testDepartment() {
        /*Department department = departmentMapper.getDeptById(1);
        System.out.println(department);*/

        /*Department department = departmentMapper.getDeptByIdStep(1);
        System.out.println(department);
        List<Employee> emps = department.getEmps();
        for (Employee emp:emps) {
            System.out.println(emp);
        }*/

        /*Department department = new Department(null, "研发部");
        Boolean flag = departmentMapper.insertDept(department);
        System.out.println(flag);*/

        List<Department> depts = new ArrayList<>();
        depts.add(new Department(null, "财务部"));
        depts.add(new Department(null, "创意部"));
        Boolean temp = departmentMapper.insertDepts(depts);
        System.out.println(temp);
    }

}
