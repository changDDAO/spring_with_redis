package com.changddao.spring_with_redis.dto;

import lombok.Data;

import java.time.Duration;

@Data
public class RedisDto {
    private String key;
    private String value;
    private Duration duration;
}
