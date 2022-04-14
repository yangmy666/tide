package org.yangmy.tide.service.system.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionVo {

    //面试题id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    //面试题
    private String question;
    //提问者
    private String questioner;
    //面试题获赞数量
    @JsonSerialize(using = ToStringSerializer.class)
    private Long likeNum;
    //当前用户是否赞了
    private Boolean isLike;
}
