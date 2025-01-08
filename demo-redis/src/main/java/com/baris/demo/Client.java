package com.baris.demo;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("Student")
public class Client {

    private Integer id;

    private String name;

    private String email;
}
