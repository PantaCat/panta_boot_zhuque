package com.panta.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SftpModel {

    public static String host;
    public static int port;
    public static String userName;
    public static String passWord;
    public static String imgBasePath;
    public static String imgBaseUrl;
    
    @Value("${LINUXADDRESS}")
    public void setHost(String host) {
        this.host = host;
    }
    
    @Value("${LINUXPORT}")
    public void setPort(int port) {
        this.port = port;
    }
    
    @Value("${LINUXUSERNAME}")
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Value("${LINUXPASSWORD}")
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    @Value("${LINUXIMGPATH}")
    public void setImgBasePath(String imgBasePath) {
        this.imgBasePath = imgBasePath;
    }
    
    @Value("${IMGURL}")
    public void setImgBaseUrl(String imgBaseUrl) {
        this.imgBaseUrl = imgBaseUrl;
    }
}
