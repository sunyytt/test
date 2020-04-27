package me.fun.system.service.impl;

import me.fun.system.config.SecurityProperties;
import me.fun.system.entity.LoginUseDTO;
import me.fun.system.entity.domain.UserOnline;
import me.fun.system.repository.UserOnlineRepository;
import me.fun.system.service.OnlineUserService;
import me.fun.system.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * @ClassName: OnlineUserServiceImpl
 * @Description: 
 * @author sunyy
 * @date 2020/4/27  
 * @version V1.0
 */
@Service
public class OnlineUserServiceImpl implements OnlineUserService {
    @Autowired
    private UserOnlineRepository userOnlineRepository;

    @Override
    public void save(LoginUseDTO authUser, HttpServletRequest request){
        UserOnline userOnline = new UserOnline();
        userOnline.setUsername(authUser.getUsername());
        String ip = StringUtils.getIp(request);
        userOnline.setIp(ip);
        userOnline.setBrowser(StringUtils.getBrowser(request));
        userOnline.setAddress(StringUtils.getCityInfo(ip));
        userOnline.setLoginTime(new Timestamp(System.currentTimeMillis()));
        userOnlineRepository.save(userOnline);
    }
}
