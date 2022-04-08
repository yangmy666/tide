package org.yangmy.tide.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author YangMingYang
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result{

    private Integer status;
    private String message;
    private Object data;

    public Result(Status status,String message,Object data){
        this.status=status.getValue();
        this.message=message;
        this.data=data;
    }

    public static Result ok(Object data){
        return new Result(Status.ok,null,data);
    }

    public static Result ok(){
        return new Result(Status.ok,null,null);
    }

    public static Result success(String message,Object data){
        return new Result(Status.success,message,data);
    }

    public static Result warning(String message,Object data){
        return new Result(Status.warning,message,data);
    }

    public static Result failure(String message,Object data){
        return new Result(Status.failure,message,data);
    }

    public static Result success(String message){
        return new Result(Status.success,message,null);
    }

    public static Result warning(String message){
        return new Result(Status.warning,message,null);
    }

    public static Result failure(String message){
        return new Result(Status.failure,message,null);
    }
}
