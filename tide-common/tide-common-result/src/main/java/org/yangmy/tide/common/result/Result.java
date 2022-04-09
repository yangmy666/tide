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
    private String title;
    private Object data;

    public Result(Status status,String title,Object data){
        this.status=status.getValue();
        this.title=title;
        this.data=data;
    }

    public static Result ok(Object data){
        return new Result(Status.ok,null,data);
    }

    public static Result ok(){
        return new Result(Status.ok,null,null);
    }

    public static Result success(String title,Object data){
        return new Result(Status.success,title,data);
    }

    public static Result warning(String title,Object data){
        return new Result(Status.warning,title,data);
    }

    public static Result failure(String title,Object data){
        return new Result(Status.failure,title,data);
    }

    public static Result success(String title){
        return new Result(Status.success,title,null);
    }

    public static Result warning(String title){
        return new Result(Status.warning,title,null);
    }

    public static Result failure(String title){
        return new Result(Status.failure,title,null);
    }
}
