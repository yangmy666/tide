package org.yangmy.tide.service.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.service.system.service.IRecommendService;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@RestController
@RequestMapping("/recommend")
public class RecommendController {

    @Autowired
    private IRecommendService recommendService;

    /**
     * 首页推荐
     * @return 面试题目集合
     */
    @GetMapping("/load")
    public Result load(){
        return Result.ok(recommendService.recommend());
    }
}
