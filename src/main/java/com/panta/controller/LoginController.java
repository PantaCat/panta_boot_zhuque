package com.panta.controller;

import com.panta.model.login.LoginUser;
import com.panta.model.utils.ResponseModel;
import com.panta.service.login.ILoginService;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @PostMapping("/login")
    public ResponseModel login(HttpServletRequest request, HttpServletResponse response, @RequestBody LoginUser loginUser){
        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        remoteAddr = remoteAddr.replace(".","");


        String cookie_zhuqueUserName = null;
        boolean cookieCheck = false;
        // 检查设备的Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("zhuqueUserName"+remoteAddr)){
                    cookie_zhuqueUserName = cookie.getValue();
                    break;
                }
            }
        }
        ResponseModel responseModel = new ResponseModel();
        if(cookieCheck){
            responseModel.setCode("200");
            return responseModel;
        }
        if(StringUtils.isBlank(loginUser.getUserName()) || StringUtils.isBlank(loginUser.getPassWord())){
            responseModel.setCode("100");
            responseModel.setMsg("登录失败，账号或者密码错误!");
            return responseModel;
        }
        Long count = loginService.queryUserLoginCount(loginUser);
        if(count > 0){
            Cookie cookie = new Cookie("zhuqueUserName"+remoteAddr, loginUser.getUserName());
            cookie.setMaxAge(50000);
            response.addCookie(cookie);
            responseModel.setCode("200");
            return responseModel;
        }
        responseModel.setCode("100");
        responseModel.setMsg("登录失败，账号或者密码错误!");
        return responseModel;
    }
}
