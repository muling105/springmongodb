package com.ztes.springmongodb.repository;

import com.ztes.springmongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author ze
 * @create 2018/11/7
 * @description
 */
public interface UserRepository extends MongoRepository<User, Long> {

    /**
     * Like（模糊查询）
     * {"username" : name} ( name as regex)
     * */
    List<User> findByUsernameLike(String username);

    /**
     * Like（模糊查询）
     * {"username" : name}
     * */
    List<User> findByUsername(String username);

    /**
     * GreaterThan(大于)
     * {"age" : {"$gt" : age}}
     * */
    List<User> findByAgeGreaterThan(int age);
    /**
     * LessThan（小于）
     * {"age" : {"$lt" : age}}
     * */
    List<User> findByAgeLessThan(int age);
    /**
     * Between（在...之间）
     * {{"age" : {"$gt" : from, "$lt" : to}}
     * */
    List<User> findByAgeBetween(int from, int to);

    /**
     * IsNotNull, NotNull（是否非空）
     *  {"username" : {"$ne" : null}}
     * */
    List<User> findByUsernameNotNull();

    /**
     * IsNull, Null（是否为空）
     *   {"username" : null}
     * */
    List<User> findByUsernameNull();


    /**
     * Not（不包含）
     *    {"username" : {"$ne" : name}}
     * */
    List<User> findByUsernameNot(String name);


}