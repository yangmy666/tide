package org.yangmy.tide.common.result;

/**
 * @author YangMingYang
 */
public enum Status {

    SUCCESS(200,"处理成功"),
    ERROR(500,"服务器内部错误");

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
