package com.panta.config;

import com.panta.utils.redis.RedisUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtil redisUtil;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取客户端IP
        String remoteAddr = getRemoteAddr(request);

        if(redisUtil.exists("zhuque_login_"+remoteAddr)){
            // 用户已登录，继续请求处理
            return true;
        }
        //清除用户cookie(有效期为0，就等于清除)
        Cookie cookie = new Cookie("zhuqueloginuser", "logout");
        cookie.setMaxAge(0);
        cookie.setPath("/");//对所有路径可见
        response.addCookie(cookie);
        return false;
    }

    public String getRemoteAddr(HttpServletRequest request){
        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
            remoteAddr = remoteAddr.replace(".","");
        }

        return remoteAddr;
    }
}