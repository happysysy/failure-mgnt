package com.lottevn.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum ApiResultCodeEnum {
    SUCCESS(0, "Request succeed", ""),
    ERROR_INVALID_REQUEST(1, "Invalid request","Request with wrong format or parameters"),
    ERROR_UNAUTHORIZED_REQUEST(2, "Unauthorized request", ""),
    ERROR_USER_NOT_FOUND(10, "Credentials not found", "Username not found"),
    ERROR_USER_NOT_ACTIVE(11, "Credentials not available", "User is not active"),
    ERROR_TOKEN_EXPIRED(12, "Credentials expired", "Token expired"),

    ERROR_ORDER_NOT_FOUND(20, "Order not found", "Could not found any Order with input IDs"),
    ERROR_CATEGORY_NOT_FOUND(21, "Category IDs not found", "Could not found any Category with input IDs"),
    ERROR_PRODUCT_NOT_FOUND(22, "Product IDs not found", "Could not found any Product with input IDs"),

    ERROR_GRAB_NOT_DELIVERY(30, "It's not Grab Delivery", "It's not Grab Delivery"),

    ERROR_INSERT_FAILED(50, "Insert failed", "Insert failed"),
    ERROR_UPDATE_FAILED(51, "Update failed", "Update failed"),


    ERROR_ACCESS_DENIED(70, "Access is denied", "Access is denied"),
    ERROR_FULL_AUTHENTICATION_IS_REQUIRED(71, "Full authentication is required to access this resource", "Full authentication is required to access this resource"),

    ERROR_ID_ALREADY_IN_USE(90, "This id is already in use.", "This id is already in use."),

    ERROR_SYSTEM(99, "SYSTEM ERROR", "SYSTEM ERROR"),

    ;

    private static final Map<Integer, ApiResultCodeEnum> CODE_TO_ENUM = new HashMap<Integer, ApiResultCodeEnum>();
    static { // Initialize map from legacy code to enum constant
        for (final ApiResultCodeEnum code : values()) {
            CODE_TO_ENUM.put(code.getCode(), code);
        }
    }

    private int code;
    private String message;
    private String description;

    private ApiResultCodeEnum(final int code, final String message, final String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public static String getByMessage(int code) {
        for(ApiResultCodeEnum e : values()) {
            if(e.getCode() == code) return e.getMessage();
        }
        return "";
    }

    public static String getByDescription(int code) {
        for(ApiResultCodeEnum e : values()) {
            if(e.getCode() == code) return e.getDescription();
        }
        return "";
    }

    /**
     * 코드 값에 해당되는 enum 검색
     *
     * @param code
     * @return
     */
    public static Boolean valueOfCode(final String code) {
        if (code == null) {
            return false;
        }
        final ApiResultCodeEnum CodeEnum = CODE_TO_ENUM.get(code);
        if (CodeEnum == null) {
            //throw new IllegalArgumentException("No enum constant for this code: " + code);
            return false;
        }

        return true;
    }


}
