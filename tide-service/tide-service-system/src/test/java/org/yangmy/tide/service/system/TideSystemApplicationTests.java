package org.yangmy.tide.service.system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TideSystemApplicationTests {

    @Qualifier(value = "localJdbcTemplate")
    @Autowired
    JdbcTemplate localJdbcTemplate;

    @Qualifier(value = "aliyunJdbcTemplate")
    @Autowired
    JdbcTemplate aliyunJdbcTemplate;

    @Transactional
    @Test
    void contextLoads(){

        /*List<Map<String,Object>> list1 = aliyunJdbcTemplate.queryForList("show status");
        for (Map<String, Object> map : list1) {
            System.out.println(map.toString());
        }*/

    }

}
