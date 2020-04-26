package me.fun.system.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
/**
 * @ClassName: LoginUseDTO
 * @Description: 
 * @author sunyy
 * @date 2020/4/26  
 * @version V1.0
 */  
@Data
public class LoginUseDTO {

    @ApiModelProperty(value = "账号/手机号")
    @NotBlank
    private String username;
    @ApiModelProperty(value = "密码")
    @NotBlank
    private String password;
    @ApiModelProperty(value = "校验码")
    @NotBlank
    private String code;
    @ApiModelProperty(value = "uuid")
    @NotBlank
    private String uuid = "";

}
