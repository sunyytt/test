package me.fun.system.web;

import cn.hutool.core.util.IdUtil;
import com.wf.captcha.ArithmeticCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.fun.system.config.SecurityProperties;
import me.fun.system.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: LoginController
 * @Description: 登录接口
 * @author sunyy
 * @date 2020/4/24
 * @version V1.0
 */
@Slf4j
@RestController
@Api(tags = "系统管理：登录接口")
public class LoginController {
    /**
     * 登录图形验证码有效时间/分钟
     */
    @Value("${loginCode.expiration}")
    private Long expiration;

    @Autowired
    private SecurityProperties properties;

    @Autowired
    private RedisUtils redisUtils;


}
