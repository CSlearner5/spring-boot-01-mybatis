package com.demo.springbootmybatis.Mapper;

import com.demo.springbootmybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public Employee getEmpAndDept(Integer id);

    public List<Employee> getEmpsByCondition(Employee employee);

    public List<Employee> getEmpsByOneCondition(Employee employee);

    public List<Employee> getEmpsByIdForearch(@Param("ids") List<Integer> ids);

    @MapKey("id")
    public Map<Integer, Employee> getEmpsByDeptId(Integer did);

    public Boolean insertEmpById(Employee employee);

    public Boolean updateEmpById(Employee employee);

    public Boolean deleteEmpById(Integer id);
}
