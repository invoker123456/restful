package com.invoker.restful.mapper;

import com.invoker.restful.entity.Testuser;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//这里可以不使用注解，在启动类中加上MapperScan注解，里面添加该mapper所在的包路径即可
public interface UserMapper {

    //使用注解式开发查询语句
    @Select("SELECT * FROM Tuser WHERE ID = #{id}")
    Testuser getUserById(@Param("id") String id);

    @Select("select * from Tuser order by id asc")
    List<Testuser> getAllUser();

//    @Insert("INSERT INTO Tuser(ID, NAME, SEX) VALUES(#{id}, #{name}, #{sex})")
//    int insert(@Param("id") Integer id, @Param("name") String name, @Param("sex") String sex);

    @Insert("INSERT INTO Tuser(ID, NAME, SEX) VALUES(#{id}, #{name}, #{sex})")
    int insert(Testuser user);

    @Update("update Tuser set ID = #{id}, NAME = #{name}, SEX = #{sex} where id = #{id}")
    int update(Testuser user);

    @Delete("delete Tuser where id = #{id}")
    public int deleteUserById(Integer id);
}
