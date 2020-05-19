package com.lottevn.core.model.api;

import com.lottevn.core.model.Dto;
import lombok.Data;

@Data
public class GenericResponse<T> implements Dto {

    private static final long serialVersionUID = -6418383313099627764L;

    private int error;
    private String message;
    private T result;
}
