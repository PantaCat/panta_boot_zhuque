package com.panta.model.link;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
public class LinkModel implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 序号
     */
    private Integer number;
    /**
     * 地址
     */
    private String linkAddress;
    /**
     * 图片存储地址
     */
    private String imgAddress;
}
