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



}
