package org.yangmy.tide.service.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
//不序列化null值
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    //用string的方式序列化long类型解决精度问题
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @NotBlank(message = "用户名不能为空",groups = {LoginGroup.class,RegisterGroup.class})
    private String username;

    @NotBlank(message = "密码不能为空",groups = {LoginGroup.class,RegisterGroup.class})
    private String password;

}
