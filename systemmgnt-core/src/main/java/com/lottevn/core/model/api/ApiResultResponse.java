package com.lottevn.core.model.api;

import com.lottevn.core.model.Dto;
import lombok.Data;

@Data
public class ApiResultResponse implements Dto {
    private static final long serialVersionUID = 5756607335505957900L;

    private int status;
    private String message;
    private Object data;
}
