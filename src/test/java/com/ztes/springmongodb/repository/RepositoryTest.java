package com.ztes.springmongodb.repository;

import com.ztes.springmongodb.entity.User;
import com.ztes.springmongodb.service.UserService;
import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author ze
 * @create 2018/11/7
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class RepositoryTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveOne(){
        User user = userService.save(new User(3L, "mdmd", 18));
        Assert.assertNotNull(user);
    }

    @Test
    public void saveTeo(){
        User u = new User();
        u.setId(4L).setUsername("jiejie").setAge(20);
        User user = userService.save(u);
        Assert.assertNotNull(user);
    }

    @Test
    public void findOne(){
        User user = userService.findById(1L);
        Assert.assertNotNull(user);
    }

    @Test
    public void updateOne(){
        User user = userService.findById(1L);
        user.setAge(26);
        User user1 = userService.save(user);
        log.info(user1.getAge().toString());
    }

    @Test
    public void delete(){
        User user = userService.findById(3L);
        userService.delete(user);
    }

    @Test
    public void findByNameLike(){
        List<User> list = userService.findByUsernameLike("d");
        log.info("List size is : " + list.size());
        Assert.assertNotNull(list);
    }

}
