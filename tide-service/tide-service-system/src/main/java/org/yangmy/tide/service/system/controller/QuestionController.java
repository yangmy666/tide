package org.yangmy.tide.service.system.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.service.system.entity.Question;
import org.yangmy.tide.service.system.service.IQuestionService;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    @GetMapping("/list")
    public Result list(Question question){
        Wrapper<Question> wrapper=new QueryWrapper<>(question);
        return Result.ok(questionService.list(wrapper));
    }

    /**
     * 首页推荐
     * @return 面试题目集合
     */
    @GetMapping("/recommend")
    public Result recommend(){
        return Result.ok(questionService.recommend());
    }
}
