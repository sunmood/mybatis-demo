package com.sunmood.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by sunmood on 2019/6/1.
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Long managerId;
    private LocalDateTime createTime;
}
