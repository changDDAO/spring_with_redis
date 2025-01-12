package com.changddao.spring_with_redis.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.List;

@Data
public class RedisUserDto {
    private String key;
    private List<UserDto> userList;
    private Duration duration;


    @Data
     private static class UserDto {
        private String name;
        private Integer age;
        private Integer height;
     }
}
