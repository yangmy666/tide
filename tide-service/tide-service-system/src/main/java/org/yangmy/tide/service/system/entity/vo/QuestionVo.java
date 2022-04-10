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

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String question;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long star;
    private String questioner;
}
