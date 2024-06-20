package com.panta.service.login;


import com.panta.model.login.LoginUser;

public interface ILoginService {
    
    Long queryUserLoginCount(LoginUser loginUser);

}
