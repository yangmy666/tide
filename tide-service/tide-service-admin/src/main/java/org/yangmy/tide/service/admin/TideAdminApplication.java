package org.yangmy.tide.service.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class TideAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(TideAdminApplication.class, args);
    }

}
