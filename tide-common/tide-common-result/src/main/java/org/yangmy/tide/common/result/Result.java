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

    public static Result success(){
        return new Result(Status.OK);
    }

    public static Result success(Object data){
        return new Result(Status.OK,data);
    }

    public static Result FAILURE(Status status){
        return new Result(status);
    }

    public static Result FAILURE(Status status,Object data){
        return new Result(status,data);
    }

}
