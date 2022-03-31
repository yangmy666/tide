package org.yangmy.tide.service.demo.entity.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author YangMingYang
 */
@Data
public class ADto {

    @NotNull(message = "id不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @NotBlank(message = "名称不能为空")
    private String name;
}
