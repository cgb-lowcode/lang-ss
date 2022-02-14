package com.sumslack.webapp.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CodeVO implements Serializable {
    private String code;
    private String params;
}
