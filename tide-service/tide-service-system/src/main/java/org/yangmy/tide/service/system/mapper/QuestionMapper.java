package org.yangmy.tide.service.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.yangmy.tide.service.system.entity.Question;
import org.yangmy.tide.service.system.entity.vo.QuestionVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author YangMingYang
 * @since 2022-04-10
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

    List<QuestionVo> recommend();

}
