package com.changddao.spring_with_redis.service;

import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * Redis 단일 데이터를 처리하는 비즈니스 로직 인터페이스 입니다
 */
@Service
public interface RedisSingleDataService {
    //Redis 단일 데이터 값을 등록/수정합니다.
    int setSingleData(String key, Object Value);
    //Redis 단일 데이터 값을 등록/수정합니다.(duration 값이 존재하면 메모리 상 유효시간을 지정합니다.)
    int setSingleData(String key, Object value, Duration duration);
    //Redis 키를 기반으로 단일 데이터의 값을 조회합니다.
    Object getSingleData(String key);
    //Redis 키를 기반으로 단일 데이터의 값을 삭제합니다.
    int deleteSingleData(String key);
}
