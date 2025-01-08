package com.changddao.spring_with_redis.service.impl;

import com.changddao.spring_with_redis.config.RedisHandler;
import com.changddao.spring_with_redis.service.RedisSingleDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class RedisSingleDataServiceImpl implements RedisSingleDataService {
    private final RedisHandler redisHandler;

    @Override
    public int setSingleData(String key, Object Value) {
        return 0;
    }

    @Override
    public int setSingleData(String key, Object value, Duration duration) {
        return 0;
    }

    @Override
    public String getSingleData(String key) {
        return "";
    }

    @Override
    public int deleteSingleData(String key) {
        return 0;
    }
}
