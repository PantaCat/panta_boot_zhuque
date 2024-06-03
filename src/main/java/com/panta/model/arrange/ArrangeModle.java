package com.panta.model.arrange;

import lombok.Data;

import java.io.Serializable;
@Data
public class ArrangeModle implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 服务器地址
     */
    private String linuxAddress;
    /**
     * 执行命令
     */
    private String executeCommand;
}
