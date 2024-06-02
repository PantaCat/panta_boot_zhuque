package com.panta.utils;

import com.jcraft.jsch.*;
import com.panta.model.SftpModel;

import java.io.InputStream;

public class FtpUtil {
    public static void uploadFile(InputStream input , String fileName ) {
        JSch jsch = new JSch();
        Session session = null;
        Channel channel = null;
        try {
            // 开启Session并连接
            session = jsch.getSession(SftpModel.userName,SftpModel.host ,SftpModel.port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(SftpModel.passWord);
            session.connect();

            // 打开SFTP通道
            channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftp = (ChannelSftp) channel;
            //使用ChannelSftp对象进行使用命令
            //进入需要进入的路径
            sftp.cd(SftpModel.basePath);
            //进行文件上传
            sftp.put(input,fileName);
            
            System.out.println("File uploaded successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭通道和Session
            if (channel != null) {
                channel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
    }
}
