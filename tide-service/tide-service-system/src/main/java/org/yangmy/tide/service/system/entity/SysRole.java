package org.yangmy.tide.service.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.yangmy.common.mybatisplus.BaseEntity;

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
@TableName("sys_role")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String roleName;

}
