package com.panta.mapper.login;

import com.panta.model.login.LoginUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    Long queryUserLoginCount(LoginUser loginUser);
}
