package org.yangmy.tide.common.result;

/**
 * @author YangMingYang
 */
public enum Status {

    OK(200,"操作成功"),

    VALID(406,"参数校验错误"),
    LOGIN_FAILURE(407,"登录失败，用户名或密码错误"),
    INTERNAL_ERROR(500,"服务器内部错误");


    private final Integer code;
    private final String message;

    public Integer code(){
        return this.code;
    }
    public String message(){
        return this.message;
    }

    Status(Integer code, String message){
        this.code=code;
        this.message=message;
    }

}
