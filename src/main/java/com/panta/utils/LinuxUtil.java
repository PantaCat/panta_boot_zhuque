package com.panta.utils;

import com.jcraft.jsch.*;
import com.panta.model.SftpModel;

public class LinuxUtil {
    public static void sshExec( String command) throws InterruptedException {
        JSch jsch = new JSch();
        Session session = null;
        ChannelExec exec = null;
        try {
            // 开启Session并连接
            session = jsch.getSession(SftpModel.userName,SftpModel.host ,SftpModel.port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(SftpModel.passWord);
            session.connect();

            //启动exec 执行命令
            exec = (ChannelExec)session.openChannel("exec");
            exec.setCommand(command);
            exec.setInputStream(null);
            exec.setErrStream(System.err);
            exec.connect();
            System.out.println("SshExec successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(1000*60*2);//延迟两分钟关闭
            // 关闭通道和Session
            if (exec != null) {
                exec.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
    }
}
