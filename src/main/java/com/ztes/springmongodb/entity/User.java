package com.ztes.springmongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author ze
 * @create 2018/11/7
 * @description
 */

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = -7182080570237023185L;

    @Id
    private Long id;
    private String username;
    private Integer age;

}
