package org.yangmy.tide.service.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.yangmy.tide.service.system.entity.valid.LoginGroup;
import org.yangmy.tide.service.system.entity.valid.RegisterGroup;

import javax.validation.constraints.NotBlank;
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
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @NotBlank(message = "用户名不能为空",groups = {LoginGroup.class,RegisterGroup.class})
    private String username;

    @NotBlank(message = "密码不能为空",groups = {LoginGroup.class,RegisterGroup.class})
    private String password;

}
