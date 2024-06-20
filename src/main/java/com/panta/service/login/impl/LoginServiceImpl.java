package com.panta.service.login.impl;

import com.panta.mapper.login.LoginMapper;
import com.panta.model.login.LoginUser;
import com.panta.service.login.ILoginService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {
    
   @Resource 
   private LoginMapper loginMapper;

    @Override
    public Long queryUserLoginCount(LoginUser loginUser) {
        return loginMapper.queryUserLoginCount(loginUser);
    }
}
