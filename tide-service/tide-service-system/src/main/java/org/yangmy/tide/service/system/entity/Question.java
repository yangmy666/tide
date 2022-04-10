package org.yangmy.tide.service.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.yangmy.tide.common.utils.BaseEntity;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("question")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String question;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long star;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long questionerId;

}
