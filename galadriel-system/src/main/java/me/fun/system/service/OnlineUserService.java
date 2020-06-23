package me.fun.system.service;

import me.fun.system.entity.LoginUseDTO;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: OnlineUserService
 * @Description:
 * @author sunyy
 * @date 2020/4/27
 * @version V1.0
 */
public interface OnlineUserService {
    /**
     * 保存在线用户信息
     * @param authUser
     * @param request
     * @return void
     * @throws
     * @author sunyy
     * @time 2020/4/27 15:49
     */
    void save(LoginUseDTO authUser, HttpServletRequest request);

   /**
    * 记录登出
    * @param userName
    * @param request
    * @return void
    * @throws
    * @author sunyy
    * @time 2020/4/27 17:42
    */
    void logOut(String userName, HttpServletRequest request);
}
