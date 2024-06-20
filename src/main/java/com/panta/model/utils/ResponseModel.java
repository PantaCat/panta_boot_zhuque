package com.panta.model.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseModel implements Serializable {
    private String code;
    private String msg;
}
