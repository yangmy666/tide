package org.yangmy.tide.service.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TideDemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext=SpringApplication.run(TideDemoApplication.class, args);
        for (String s : applicationContext.getBeanDefinitionNames()) {
            System.out.println(s);
        }
    }

}
