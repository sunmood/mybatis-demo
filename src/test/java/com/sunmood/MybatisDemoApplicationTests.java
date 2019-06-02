package com.sunmood;

import com.sunmood.entity.User;
import com.sunmood.mapper.primary.UserMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisDemoApplicationTests {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getAll(){
		List<User> users = userMapper.getAll();

		Assert.assertEquals(6,users.size());
		users.forEach(System.out::println);
	}
	@Test
	public void getAllMap(){
		List<Map<String, Object>> users = userMapper.getAllMap();

		Assert.assertEquals(6,users.size());
		users.forEach(System.out::println);
	}

	@Test
	public void getOne(){
		User user = userMapper.getOne(1L);
		System.out.println(user);
	}

	@Test
	public void getOneMap(){
		Map<String, Object> user = userMapper.getOneMap(1L);
		System.out.println(user);
	}

	@Test
	public void insert(){
		User user = new User();
		user.setId(7L);
		user.setName("小乔");
		user.setAge(18);
		user.setEmail("xq@123.com");
		user.setManagerId(userMapper.getOne(3L).getManagerId());
		user.setCreateTime(LocalDateTime.now());
		System.out.println(user);
		userMapper.insert(user);
	}

	@Test
	public void update(){
		User user = userMapper.getOne(7L);
		user.setAge(88);
		System.out.println(user);
		userMapper.update(user);
	}
	@Test
	public void delete(){
		userMapper.delete(7L);
	}

	@Test
	public void getOneByMap(){
		Map<String, Object> param = new HashMap<>();
		param.put("id",1L);
		User user = userMapper.getOneByMap(param);
		System.out.println(user);
	}

}
