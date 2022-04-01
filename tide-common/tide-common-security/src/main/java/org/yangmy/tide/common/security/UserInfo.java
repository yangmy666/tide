package org.yangmy.tide.common.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Data
//不序列化null值
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    //用string的方式序列化long类型解决精度问题
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String username;
    //权限
    private List<String> codeList;
}
