package com.ztes.springmongodb.service;

import com.ztes.springmongodb.entity.User;

import java.util.List;

/**
 * @author ze
 * @create 2018/11/8
 * @description
 */
public interface UserService {

    User save(User bean);

    User findById(Long id);

    void delete(User bean);

    List<User> findByUsernameLike(String username);

    List<User> findAll();

}
