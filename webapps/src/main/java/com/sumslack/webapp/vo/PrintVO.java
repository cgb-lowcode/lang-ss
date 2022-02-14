package com.sumslack.webapp.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PrintVO implements Serializable {
    private String tag;
    private String msg;
}
