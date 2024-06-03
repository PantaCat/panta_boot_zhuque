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
    
    @Value("${SFTP.ADDRESS}")
    public void setHost(String host) {
        this.host = host;
    }
    
    @Value("${SFTP.PORT}")
    public void setPort(int port) {
        this.port = port;
    }
    
    @Value("${SFTP.USERNAME}")
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Value("${SFTP.PASSWORD}")
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    @Value("${SFTP.BASEPATH}")
    public void setImgBasePath(String imgBasePath) {
        this.imgBasePath = imgBasePath;
    }
    
    @Value("${IMAGE.BASE.URL}")
    public void setImgBaseUrl(String imgBaseUrl) {
        this.imgBaseUrl = imgBaseUrl;
    }
}
