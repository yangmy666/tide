package org.yangmy.tide.common.utils;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Data
public class BaseEntity {

    @TableId("id")
    //用string的方式序列化long类型解决精度问题
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    @TableLogic
    private Integer delFlag;
}
