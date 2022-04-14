package org.yangmy.tide.service.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.yangmy.common.mybatisplus.BaseEntity;

import java.io.Serializable;

/**
 * @author YangMingYang
 * @since 2022/4/14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("answer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Answer extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String context;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long questionId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long receiveId;
}
