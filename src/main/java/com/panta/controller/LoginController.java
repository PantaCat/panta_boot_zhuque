package com.panta.controller;

import com.panta.model.login.LoginUser;
import com.panta.model.utils.ResponseModel;
import com.panta.service.login.ILoginService;
import com.panta.utils.redis.RedisUtil;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/main")
public class LoginController {

    @Autowired
    private ILoginService loginService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/login")
    public ResponseModel login(HttpServletRequest request, HttpServletResponse response, @RequestBody LoginUser loginUser){
        //获取客户端IP
        String remoteAddr = getRemoteAddr(request);
        
        ResponseModel responseModel = new ResponseModel();
        if(StringUtils.isBlank(loginUser.getUserName()) || StringUtils.isBlank(loginUser.getPassWord())){
            responseModel.setCode("100");
            responseModel.setMsg("登录失败，账号或者密码错误!");
            return responseModel;
        }
        Long count = loginService.queryUserLoginCount(loginUser);
        if(count > 0){
            Cookie cookie = new Cookie("zhuqueloginuser", loginUser.getUserName());
            cookie.setMaxAge(600);
            cookie.setPath("/");//对所有路径可见
            response.addCookie(cookie);

            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisUtil.set("zhuque_login_"+remoteAddr,loginUser.getUserName(),600, TimeUnit.SECONDS);
            responseModel.setCode("200");
            return responseModel;
        }
        responseModel.setCode("100");
        responseModel.setMsg("登录失败，账号或者密码错误!");
        return responseModel;
    }
    
    @PostMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request,HttpServletResponse response){
        //获取客户端IP
        String remoteAddr = getRemoteAddr(request);
        //清除用户cookie(有效期为0，就等于清除)
        Cookie cookie = new Cookie("zhuqueloginuser", "logout");
        cookie.setMaxAge(0);
        cookie.setPath("/");//对所有路径可见
        response.addCookie(cookie);
        //清除redis
        redisUtil.remove("zhuque_login_"+remoteAddr);
        return ResponseEntity.ok("ok");
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
