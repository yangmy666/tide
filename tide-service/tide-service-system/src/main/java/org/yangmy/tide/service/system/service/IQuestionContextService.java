package org.yangmy.tide.service.system.service;

import org.yangmy.tide.common.result.Result;

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
    Result selectDetails(Long questionId);
}
