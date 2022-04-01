package org.yangmy.tide.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author YangMingYang
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    /**
     * 成功就是成功，只有一种结果，有返回数据和没数据
     * @return
     */
    public static Result success(){
        return new Result(Status.OK);
    }

    public static Result success(Object data){
        return new Result(Status.OK,data);
    }

    /**
     * 失败有很多种原因，具体哪种原因，有返回数据和没数据
     * @param status
     * @return
     */
    public static Result FAILURE(Status status){
        return new Result(status);
    }

    public static Result FAILURE(Status status,Object data){
        return new Result(status,data);
    }

}
