package com.panta.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SftpModel {

    public static String host;
    public static int port;
    public static String userName;
    public static String passWord;
    public static String basePath;
    public static String baseUrl;
    
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
    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
    
    @Value("${IMAGE.BASE.URL}")
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
