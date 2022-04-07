package org.yangmy.tide.common.result;

/**
 * @author YangMingYang
 */
public enum Status {

    /**
     * 0:成功 1:警告 2:错误
     */
    SUCCESS(0,"操作成功"),
    FAILURE(2,"操作失败"),
    VALID(1,"参数校验错误"),
    LOGIN_SUCCESS(0,"登录成功"),
    LOGIN_FAILURE(2,"登录失败，用户名或密码错误"),
    ERROR(2,"服务器内部错误");


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
