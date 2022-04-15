package org.yangmy.tide.service.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.service.system.service.IQuestionContextService;

/**
 * @author YangMingYang
 * @since 2022/4/14
 */
@RestController
@RequestMapping("/questionContext")
public class QuestionContextController {

    @Autowired
    private IQuestionContextService questionContextService;

    @GetMapping("/load")
    public Result load(@RequestParam("questionId") Long questionId){
        return questionContextService.selectDetails(questionId);
    }
}
