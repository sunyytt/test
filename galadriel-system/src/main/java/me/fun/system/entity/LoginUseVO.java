package me.fun.system.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName: LoginUseVO
 * @Description: 
 * @author sunyy
 * @date 2020/4/26  
 * @version V1.0
 */  
@Data
public class LoginUseVO {

    @ApiModelProperty(value = "令牌")
    @NotBlank
    private String token;

}
