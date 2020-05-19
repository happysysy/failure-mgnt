package com.lottevn.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderTypeEnum {
    ONLINE_ORDER("Online_order", "Online Order", "Lotte Online Order"),
    PHONE_ORDER("Phone_order", "Phone Order","Call Center Order"),
    CHECK_ORDER("Check_order", "webpos_order_id And lotteria_order_id Check","webpos_order_id And lotteria_order_id Check"),

    ;

    private static final Map<String, OrderTypeEnum> CODE_TO_ENUM = new HashMap<String, OrderTypeEnum>();
    static { // Initialize map from legacy code to enum constant
        for (final OrderTypeEnum code : values()) {
            CODE_TO_ENUM.put(code.getCode().toLowerCase(), code);
        }
    }

    private String code;
    private String message;
    private String description;

    private OrderTypeEnum(final String code, final String message, final String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public static String getByMessage(String code) {
        for(OrderTypeEnum e : values()) {
            if(e.getCode().equals(code)) return e.getMessage();
        }
        return "";
    }

    public static String getByDescription(String code) {
        for(OrderTypeEnum e : values()) {
            if(e.getCode().equals(code)) return e.getDescription();
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
        final OrderTypeEnum CodeEnum = CODE_TO_ENUM.get(code);
        if (CodeEnum == null) {
            //throw new IllegalArgumentException("No enum constant for this code: " + code);
            return false;
        }

        return true;
    }


}
