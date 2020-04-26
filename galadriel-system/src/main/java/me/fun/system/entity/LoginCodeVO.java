package me.fun.system.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: LoginCodeVO
 * @Description: 验证码出参
 * 显示层对象，通常是 Web 向模板渲染引擎层传输的对象
 * @author sunyy
 * @date 2020/4/24
 * @version V1.0
 */
@Data
public class LoginCodeVO {

    @ApiModelProperty(value = "唯一码")
    private String uuid;

    @ApiModelProperty(value = "验证码图像")
    private String img;

}
