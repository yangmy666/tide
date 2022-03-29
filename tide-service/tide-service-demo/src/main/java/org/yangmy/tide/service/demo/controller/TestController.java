package org.yangmy.tide.service.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yangmy.tide.common.result.ResponseResult;
import org.yangmy.tide.service.demo.entity.B;

/**
 * @author YangMingYang
 */
@RestController
@ResponseResult(exclude = {"t2"})
public class TestController {

    @GetMapping("/t1")
    public B t1(){
        B b=new B();
        b.setId(1);
        b.setName("qqq");
        b.setDeFlag(false);
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
