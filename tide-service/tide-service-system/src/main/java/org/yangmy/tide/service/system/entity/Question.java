package org.yangmy.tide.service.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.yangmy.common.mybatisplus.BaseEntity;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("question")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String question;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long like;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long questionerId;

}
