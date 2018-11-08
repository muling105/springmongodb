package com.ztes.springmongodb.service.impl;

import com.ztes.springmongodb.entity.User;
import com.ztes.springmongodb.repository.UserRepository;
import com.ztes.springmongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ze
 * @create 2018/11/8
 * @description
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User bean){
        return userRepository.save(bean);
    }

    public User findById(Long id){
        return userRepository.findById(id).get();
    }

    public void delete(User bean){
        userRepository.delete(bean);
    }

    public List<User> findByUsernameLike(String username){
        return userRepository.findByUsernameLike(username);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
