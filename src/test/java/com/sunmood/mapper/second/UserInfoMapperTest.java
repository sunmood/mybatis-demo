package com.sunmood.mapper.second;

import com.sunmood.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoMapperTest {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void getAll(){
        List<User> users = userInfoMapper.getAll();

        Assert.assertEquals(6,users.size());
        users.forEach(System.out::println);
    }
    @Test
    public void getAllMap(){
        List<Map<String, Object>> users = userInfoMapper.getAllMap();

        Assert.assertEquals(6,users.size());
        users.forEach(System.out::println);
    }

    @Test
    public void getOne(){
        User user = userInfoMapper.getOne(1L);
        System.out.println(user);
    }
}