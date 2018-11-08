package com.ztes.springmongodb.controller;

import com.ztes.springmongodb.entity.User;
import com.ztes.springmongodb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ze
 * @create 2018/11/8
 * @description
 */

@Log
@Controller()
@RequestMapping("/user")
@Api(value = "UserController | 一个用来测试swagger注解的控制器")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value ="查询所有用户",notes ="",httpMethod = "GET")
    @GetMapping("")
    @ResponseBody
    public List<User> findAll(){
        return userService.findAll();
    }

    @ApiOperation(value = "查询用户",notes = "根据用户id查询用户",httpMethod = "GET")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Long")
    @GetMapping("/find/{id}")
    @ResponseBody
    public User findOne(@PathVariable Long id){
        User user = userService.findById(id);
        return user;
    }

    @ApiOperation(value = "新增用户",notes = "",httpMethod = "POST")
    @ApiImplicitParam(name = "user",value = "用户实体",required = false,dataType = "User")
    @PostMapping("/add")
    @ResponseBody
    public User addUser(User user){
        userService.save(user);
        return user;
    }

    @ApiOperation(value = "更新用户",notes = "根据用户id更新用户",httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Long"),
            @ApiImplicitParam(name = "user",value = "用户实体,传入更改后的数据",required = false,dataType = "User")
    })
    @PutMapping("/update/{id}")
    @ResponseBody
    public User updateUser(@PathVariable Long id, User user){
        User u = userService.findById(id);
        u.setAge(user.getAge());
        u.setUsername(user.getUsername());
        return userService.save(u);
    }

    @ApiOperation(value = "删除用户", notes = "", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @DeleteMapping("delete/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable Long id){
        User user = userService.findById(id);
        userService.delete(user);
    }

}
