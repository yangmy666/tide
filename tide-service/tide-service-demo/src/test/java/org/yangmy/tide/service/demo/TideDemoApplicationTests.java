package org.yangmy.tide.service.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.yangmy.tide.service.demo.entity.M;

@SpringBootTest
class TideDemoApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    void contextLoads() {
        M m=new M();
        m.setId(1);
        m.setName("ymy");
        m.setDeFlag(true);
        redisTemplate.opsForValue().set("a",m);
    }

}
