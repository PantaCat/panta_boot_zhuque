package com.panta.model.login;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUser implements Serializable {

    private String userName;
    private String passWord;

    public LoginUser(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
}
