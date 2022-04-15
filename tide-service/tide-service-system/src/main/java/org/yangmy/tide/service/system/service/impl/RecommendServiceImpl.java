package org.yangmy.tide.service.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yangmy.tide.common.security.SecurityUtils;
import org.yangmy.tide.common.security.UserInfo;
import org.yangmy.tide.service.system.entity.Question;
import org.yangmy.tide.service.system.entity.vo.QuestionVo;
import org.yangmy.tide.service.system.mapper.QuestionMapper;
import org.yangmy.tide.service.system.service.IRecommendService;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YangMingYang
 * @since 2022-04-10
 */
@Service
public class RecommendServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IRecommendService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<QuestionVo> recommend() {
        UserInfo userInfo = SecurityUtils.getUserInfo();
        Long userId=0L;
        if(userInfo!=null){
            userId=userInfo.getId();
        }
        return questionMapper.randomQuery(userId);
    }


}
