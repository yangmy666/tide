package org.yangmy.tide.service.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/test")
    public List<Map<String,Object>> test(){
        return jdbcTemplate.queryForList("select * from music");
    }

    @GetMapping("/a")
    public String a(){
        return "a";
    }
}
