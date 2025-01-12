package com.changddao.spring_with_redis.service;

import com.changddao.spring_with_redis.config.RedisConfig;
import com.changddao.spring_with_redis.config.RedisHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisMultipleDataService {
    /* Redis에 리스트를 저장하려면 Spring Data Redis에서 제공하는 ListOperations를 활용할 수 있습니다. 아래는 Redis에 리스트 데이터를 저장하고 가져오는 방법에 대한 설명입니다.

1. ListOperations 기본 사용법
    ListOperations는 Redis의 리스트 데이터 타입과 상호작용하는 데 사용됩니다. Redis 리스트는 LPUSH, RPUSH, LPOP, RPOP, LRANGE 등의 명령어를 지원하며, 이를 통해 리스트 데이터를 추가, 삭제, 조회할 수 있습니다.
    2. 리스트 저장 방법
 */
    private final RedisHandler redisHandler;
    private final RedisConfig redisConfig;


    // 리스트 데이터를 Redis에 저장
    public void saveToList(String key, List<String> values) {
        for (String value : values) {
            redisHandler.getListOperations().rightPush(key, value); // 데이터를 오른쪽으로 추가
        }
    }

    // Redis에서 리스트 데이터 가져오기
    public List<Object> getList(String key) {
        return redisHandler.getListOperations().range(key, 0, -1); // 전체 리스트 조회
    }

    // Redis에서 특정 인덱스의 값 가져오기
    public Object getValueAtIndex(String key, long index) {
        return redisHandler.getListOperations().index(key, index);
    }

    // Redis에서 리스트 데이터 삭제
    public void deleteList(String key) {
        redisHandler.getListOperations().getOperations().delete(key); // 키 삭제
    }

}
