package org.yangmy.tide.service.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author YangMingYang
 * @since 2022-03-31
 */
@Data
@TableName("sys_role")
//不序列化null值
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    //用string的方式序列化long类型解决精度问题
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String roleName;

}
