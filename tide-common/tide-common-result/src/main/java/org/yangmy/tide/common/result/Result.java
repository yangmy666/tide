package org.yangmy.tide.common.result;

import lombok.Data;

/**
 * @author YangMingYang
 */
@Data
public class Result{

    private Integer code;
    private String message;
    private Object data;

    public Result(Status status){
        this.code=status.code();
        this.message=status.message();
    }

    public Result(Status status, Object data){
        this.code=status.code();
        this.message=status.message();
        this.data=data;
    }

    public Result(Status status,String message, Object data){
        this.code=status.code();
        this.message=message;
        this.data=data;
    }

    /**
     * 处理成功
     */
    public static Result success(Object data){
        return new Result(Status.SUCCESS,data);
    }

    /**
     * 处理失败
     */
    public static Result ERROR(Object data){
        return new Result(Status.FAILURE,data);
    }

    /**
     * 处理失败
     */
    public static Result failure(Status status,Object data){
        return new Result(status,data);
    }
}
