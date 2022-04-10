package org.yangmy.tide.service.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.yangmy.tide.service.system.entity.Question;
import org.yangmy.tide.service.system.entity.vo.QuestionVo;
import org.yangmy.tide.service.system.mapper.QuestionMapper;
import org.yangmy.tide.service.system.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<QuestionVo> recommend() {
        return questionMapper.recommend();
    }
}
