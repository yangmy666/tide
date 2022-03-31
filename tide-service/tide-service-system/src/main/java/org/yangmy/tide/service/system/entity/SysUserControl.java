package org.yangmy.tide.service.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("sys_user_control")
public class SysUserControl implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    private Long userId;

    private Long controlId;

}
