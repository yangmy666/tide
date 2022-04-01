package org.yangmy.tide.service.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yangmy.tide.service.demo.entity.B;
import org.yangmy.tide.service.demo.entity.dto.ADto;

import javax.validation.Valid;

/**
 * @author YangMingYang
 */
@RestController
public class TestController {

    @GetMapping("/t1")
    public B t1(@Valid ADto aDto){
        B b=new B();
        b.setId(1);
        b.setName("qqq");
        b.setDeFlag(false);
        b.setADto(aDto);
        return b;
    }

    @GetMapping("/t2")
    public String t2(){
        return "t2";
    }

    @GetMapping("/t3")
    public String t3(){
        return "t3";
    }

    @GetMapping("/t4")
    public int t4(){
        return 4/0;
    }

}
