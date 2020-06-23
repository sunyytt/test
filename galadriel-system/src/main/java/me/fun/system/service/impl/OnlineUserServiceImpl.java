package me.fun.system.service.impl;

import me.fun.system.config.SecurityProperties;
import me.fun.system.entity.LoginUseDTO;
import me.fun.system.entity.domain.UserOnline;
import me.fun.system.repository.UserOnlineRepository;
import me.fun.system.service.OnlineUserService;
import me.fun.system.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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
@Async
@Service
public class OnlineUserServiceImpl implements OnlineUserService {
    @Autowired
    private UserOnlineRepository userOnlineRepository;

    @Async
    @Override
    public void save(LoginUseDTO authUser, HttpServletRequest request){
        UserOnline userOnline = new UserOnline();
        userOnline.setUserName(authUser.getUserName());
        String ip = StringUtils.getIp(request);
        userOnline.setIp(ip);
        userOnline.setBrowser(StringUtils.getBrowser(request));
        userOnline.setAddress(StringUtils.getCityInfo(ip));
        userOnline.setLoginTime(new Timestamp(System.currentTimeMillis()));
        userOnline.setType(true);
        userOnlineRepository.save(userOnline);
    }

    @Async
    @Override
    public void logOut(String userName, HttpServletRequest request){
        UserOnline userOnline = new UserOnline();
        userOnline.setUserName(userName);
        String ip = StringUtils.getIp(request);
        userOnline.setIp(ip);
        userOnline.setBrowser(StringUtils.getBrowser(request));
        userOnline.setAddress(StringUtils.getCityInfo(ip));
        userOnline.setLoginTime(new Timestamp(System.currentTimeMillis()));
        userOnline.setType(false);
        System.out.println(userOnline.toString());
        userOnlineRepository.save(userOnline);
    }
}
