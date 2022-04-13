package org.yangmy.tide.service.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.yangmy.tide.common.utils.BaseEntity;
import org.yangmy.tide.service.system.entity.valid.LoginGroup;

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
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_user")
//不序列化null值
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysUser extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "用户名不能为空",groups = {LoginGroup.class})
    private String username;

    @NotBlank(message = "密码不能为空",groups = {LoginGroup.class})
    private String password;

    private String mail;

}
