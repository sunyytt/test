package me.fun.system.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.fun.system.config.SecurityProperties;
import me.fun.system.entity.LoginUseDTO;
import me.fun.system.entity.LoginUseVO;
import me.fun.system.exception.AuthBusinessException;
import me.fun.system.exception.AuthErrorCodeEnum;
import me.fun.system.service.OnlineUserService;
import me.fun.system.utils.RedisUtils;
import me.fun.system.utils.ResponseWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private OnlineUserService onlineUserService;

    @ApiOperation("登录授权")
//    @AnonymousAccess
    @PostMapping(value = "/auth/login")
    public Object login(@Validated @RequestBody LoginUseDTO authUser, HttpServletRequest request){

        log.info("登录入参={}",authUser);
        // 查询 code
        String code = (String) redisUtils.get(authUser.getUuid());
        // 清除验证码
        redisUtils.del(authUser.getUuid());

        if (StringUtils.isBlank(code)) {
            return ResponseWrapper.error(AuthErrorCodeEnum.AE500000.message());
        }
        if (StringUtils.isBlank(authUser.getCode()) || !authUser.getCode().equalsIgnoreCase(code)) {
            return ResponseWrapper.error(AuthErrorCodeEnum.AE500001.message());
        }
        // 校验用户名密码
        // 生成token
        // 保存在线信息
        onlineUserService.save(authUser,request);
        LoginUseVO loginUse = new LoginUseVO();
        loginUse.setToken("admin-token");
        return ResponseWrapper.ok(loginUse);
    }

    @ApiOperation("登录获取用户信息")
    @GetMapping(value = "/auth/info")
    public Object getUserInfo(String  token){
        log.info("token={}",token);
        Map<String,Object> imgResult = new HashMap<String,Object>(2){{
            List<String> list = new ArrayList<>();
            list.add("admin");
            put("roles", list);
            put("introduction", "I am a super administrator");
            put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            put("name", "Super Admin");
        }};
        return ResponseWrapper.ok(imgResult);
    }

    @ApiOperation("退出登录")
//    @AnonymousAccess
    @PostMapping(value = "/auth/logout")
    public Object logout(HttpServletRequest request){
//        onlineUserService.logout(tokenProvider.getToken(request));
        System.out.println("ssssssssss");
        onlineUserService.logOut("admin",request);
        return ResponseWrapper.ok();
    }

}