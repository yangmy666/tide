package org.yangmy.tide.service.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class TideSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TideSystemApplication.class, args);
    }

    /**
     * 异步任务公用线程池
     * @return
     */
    @Bean
    public ThreadPoolExecutor threadPoolExecutor(){
        return new ThreadPoolExecutor(
                40,
                120,
                30,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(5000),
                new ThreadPoolExecutor.AbortPolicy());
    }

}
