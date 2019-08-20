package com.invoker.restful.mapper;

import com.invoker.restful.entity.Testuser;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//这里可以不使用注解，在启动类中加上MapperScan注解，里面添加该mapper所在的包路径即可
public interface UserMapper {

    //使用注解式开发查询语句
    @Select("SELECT * FROM Tuser WHERE NAME = #{name}")
    Testuser getUserByName(@Param("name") String name);

    @Insert("INSERT INTO Tuser(ID, NAME, SEX) VALUES(#{id}, #{name}, #{sex})")
    int insert(@Param("id") Integer id, @Param("name") String name, @Param("sex") String sex);


}
