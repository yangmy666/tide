package org.yangmy.tide.service.system.service;

import org.yangmy.tide.service.system.entity.vo.QuestionVo;

/**
 * @author YangMingYang
 * @since 2022/4/14
 */
public interface IQuestionContextService {

    /**
     * 查询面试题详细
     * @param questionId
     * @return
     */
    QuestionVo selectDetails(Long questionId);
}
