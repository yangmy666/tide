package org.yangmy.tide.common.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>用户信息包装类</p>
 * @author YangMingYang
 * @since 2022-03-31
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    //用string的方式序列化long类型解决精度问题
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    //用户名
    private String username;
    //用户拥有的前端权限编码
    private List<String> pageCodeList;
    //用户拥有的后端权限编码
    private List<String> apiCodeList;
}
