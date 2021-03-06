package org.yangmy.tide.service.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.yangmy.tide.service.system.entity.Question;
import org.yangmy.tide.service.system.entity.vo.QuestionVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YangMingYang
 * @since 2022-04-10
 */
public interface IRecommendService extends IService<Question> {

    List<QuestionVo> load();

}
