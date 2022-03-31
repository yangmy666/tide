package org.yangmy.tide.service.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"org.yangmy.tide.service.system.mapper"})
@SpringBootApplication
public class TideSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TideSystemApplication.class, args);
    }

}
