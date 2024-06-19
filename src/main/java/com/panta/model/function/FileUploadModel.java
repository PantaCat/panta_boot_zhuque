package com.panta.model.function;

import lombok.Data;

import java.io.Serializable;

@Data
public class FileUploadModel implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 文件ID
     */
    private String fileUid;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 名称地址
     */
    private String fileUrl;
}
