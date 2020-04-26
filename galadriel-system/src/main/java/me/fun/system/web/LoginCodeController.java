package me.fun.system.web;

import cn.hutool.core.util.IdUtil;
import com.wf.captcha.ArithmeticCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.fun.system.config.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import me.fun.system.utils.ResponseWrapper;
import me.fun.system.utils.RedisUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: LoginCodeController
 * @Description: 登录验证码接口
 * @author sunyy
 * @date 2020/4/24
 * @version V1.0
 */
@Slf4j
@RestController
@Api(tags = "系统管理：登录验证码接口")
public class LoginCodeController{
    /**
     * 登录图形验证码有效时间/分钟
     */
    @Value("${loginCode.expiration}")
    private Long expiration;

    @Autowired
    private SecurityProperties properties;

    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation("获取验证码")
    @GetMapping(value = "/auth/code")
    public Object getCode(){
        // 算术类型 https://gitee.com/whvse/EasyCaptcha
        // Java图形验证码
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(111, 36);
        // 几位数运算，默认是两位
        captcha.setLen(2);
        // 获取运算的结果
        String result = captcha.text();
        String uuid = properties.getCodeKey() + IdUtil.simpleUUID();
        // 保存
        redisUtils.set(uuid, result, expiration, TimeUnit.MINUTES);
        // 验证码信息
        Map<String,Object> imgResult = new HashMap<String,Object>(2){{
            put("img", captcha.toBase64());
            put("uuid", uuid);
        }};
        return ResponseEntity.ok(imgResult);
    }


}
