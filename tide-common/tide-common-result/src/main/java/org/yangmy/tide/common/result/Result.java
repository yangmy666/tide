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

    public Result(Integer status,String message,Object data){
        this.status=status;
        this.message=message;
        this.data=data;
    }

    public static Result success(String message,Object data){
        return new Result(0,message,data);
    }

    public static Result warning(String message,Object data){
        return new Result(1,message,data);
    }

    public static Result failure(String message,Object data){
        return new Result(2,message,data);
    }
}
