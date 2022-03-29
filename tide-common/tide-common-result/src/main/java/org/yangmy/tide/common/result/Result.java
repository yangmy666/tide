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

    public Result(Status status, Object data){
        this.code=status.code();
        this.message=status.message();
        this.data=data;
    }

    public Result(Status status){
        this.code=status.code();
        this.message=status.message();
    }

    /**
     * 处理成功
     * @param data
     * @return
     */
    public static Result success(Object data){
        return new Result(Status.SUCCESS,data);
    }

    /**
     * 处理失败
     * @return
     */
    public static Result failure(Object data){
        return new Result(Status.ERROR);
    }
}
