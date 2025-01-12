package com.changddao.spring_with_redis.service.impl;

import com.changddao.spring_with_redis.config.RedisConfig;
import com.changddao.spring_with_redis.config.RedisHandler;
import com.changddao.spring_with_redis.service.RedisSingleDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * Redis 단일 데이터를 처리하는 비지니스 로직 구현체입니다.
 */
@Service
@RequiredArgsConstructor
public class RedisSingleDataServiceImpl implements RedisSingleDataService {
    private final RedisHandler redisHandler;
    private final RedisConfig redisConfig;

    /**
     * Redis 단일 데이터 값을 등록/수정합니다.
     * @param key : redis key
     * @param Value : redis value
     * @return {int} 성공(1), 실패(0)
     */
    @Override
    public int setSingleData(String key, Object Value) {
        return redisHandler.executeOperation(() -> redisHandler.getValueOperations().set(key, Value));
    }

    /**
     * Redis 단일 데이터 값을 등록/수정합니다.(duration 값이 존재하면 메모리 상 유효시간을 지정합니다.)
     * @param key : redis key
     * @param value : redis value
     * @param duration : redis 값 메모리 상의 유효시간
     * @return {int} 성공(1), 실패(0)
     */
    @Override
    public int setSingleData(String key, Object value, Duration duration) {
        return redisHandler.executeOperation(()-> redisHandler.getValueOperations().set(key, value, duration));
    }

    /**
     * Redis 키를 기반으로 단일 데이터의 값을 조회합니다.
     * @param key : redis key
     * @return {String} redis value 값 반환 or 미 존재시 Null 반환
     */
    @Override
    public String getSingleData(String key) {
        if(redisHandler.getValueOperations().get(key)==null) return "redis서버에 존재하지 않는 key입니다.";
        return String.valueOf(redisHandler.getValueOperations().get(key));

    }

    /**
     * Redis 키를 기반으로 단일 데이터의 값을 삭제합니다.
     * @param key : redis key
     * @return {int} 성공(1), 실패(0)
     */
    @Override
    public int deleteSingleData(String key) {
        return redisHandler.executeOperation(()->redisConfig.redisTemplate().delete(key));
    }
}
