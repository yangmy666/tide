package org.yangmy.tide.common.utils;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Data
public class BaseEntity {

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    @TableLogic
    private Integer delFlag;
}
