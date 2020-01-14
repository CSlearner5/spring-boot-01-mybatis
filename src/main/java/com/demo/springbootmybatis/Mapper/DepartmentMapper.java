package com.demo.springbootmybatis.Mapper;

import com.demo.springbootmybatis.bean.Department;
import com.demo.springbootmybatis.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper {

    public Department getDeptById(Integer id);

    public Department getDeptByIdPlus(Integer id);

    public Department getDeptByIdStep(Integer id);
}
