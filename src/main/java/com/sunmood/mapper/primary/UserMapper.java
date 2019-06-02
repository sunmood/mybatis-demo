package com.sunmood.mapper.primary;

import com.sunmood.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by sunmood on 2019/6/1.
 * 基于注解开发和xml文件开发都可以使用该接口，不需要再进行修改
 * 只需要修改配置文件即可
 */
public interface UserMapper {

    @Select("select * from user")
    @Results({
            @Result(property = "managerId", column = "manager_id"),
            @Result(property = "createTime", column = "create_time")
    })
    List<User> getAll();

    @Select("select * from user")
    List<Map<String, Object>> getAllMap();

    @Select("select * from user where id = #{id}")
    User getOne(Long id);

    @Select("select * from user where id = #{id}")
    Map<String, Object> getOneMap(Long id);

    @Insert("insert into user(id,name,age,email,manager_id,create_time) " +
            "values(#{id},#{name},#{age},#{email},#{managerId},#{createTime})")
    void insert(User user);

    @Update("update user set age=#{age} where id=#{id}")
    void update(User user);

    @Delete("delete from user where id=#{id}")
    void delete(Long id);

    @Select("select * from user where id = #{id}")
    User getOneByMap(Map<String,Object> param);
}
