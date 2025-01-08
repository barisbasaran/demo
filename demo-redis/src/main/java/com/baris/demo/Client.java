package com.baris.demo;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@Builder
@RedisHash("Student")
public class Client {

    private Integer id;

    private String name;

    private String email;
}
