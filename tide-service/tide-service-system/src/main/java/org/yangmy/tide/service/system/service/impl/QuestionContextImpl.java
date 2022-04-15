package org.yangmy.tide.service.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.common.security.SecurityUtils;
import org.yangmy.tide.common.security.UserInfo;
import org.yangmy.tide.service.system.mapper.QuestionMapper;
import org.yangmy.tide.service.system.service.IQuestionContextService;

/**
 * @author YangMingYang
 * @since 2022/4/14
 */
@Service
public class QuestionContextImpl implements IQuestionContextService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public Result selectDetails(Long questionId) {
        UserInfo userInfo = SecurityUtils.getUserInfo();
        Long userId=0L;
        if(userInfo!=null){
            userId=userInfo.getId();
        }
        return Result.load(questionMapper.selectDetails(userId,questionId));
    }
}
