package com.changddao.spring_with_redis.controller;

import com.changddao.spring_with_redis.dto.RedisDto;
import com.changddao.spring_with_redis.dto.RedisUserDto;
import com.changddao.spring_with_redis.service.RedisSingleDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/redis/userData")
public class RedisUserController {
    private final RedisSingleDataService redisSingleDataService;

    public RedisUserController(RedisSingleDataService redisSingleDataService) {
        this.redisSingleDataService = redisSingleDataService;
    }

    /**
     * Redis 키를 기반으로 단일 데이터의 값을 조회합니다.
     *
     * @param userDto
     * @return
     */
    @PostMapping("/getValue")
    public ResponseEntity<Object> getValue(@RequestBody RedisUserDto userDto) {

        Object result = redisSingleDataService.getSingleData(userDto.getKey());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Redis 단일 데이터 값을  등록/수정합니다. (duration 값이 존재하면 메모리 상 유효시간을 지정합니다.)
     * @param userDto
     * @return
     */
    @PostMapping("/setValue")
    public ResponseEntity<Object> setValue(@RequestBody RedisUserDto userDto) {
        int result = 0;
        if (userDto.getDuration() == null) {
            result = redisSingleDataService.setSingleData(userDto.getKey(), userDto.getUserList());
        }else{
            result = redisSingleDataService.setSingleData(userDto.getKey(), userDto.getUserList(), userDto.getDuration());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteRow(@RequestBody RedisDto redisDto) {
        int result = redisSingleDataService.deleteSingleData(redisDto.getKey());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
