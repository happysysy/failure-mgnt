package com.lottevn.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum ShippingMethodEnum {
    LOTTERIA("lotteria", "Lotteria Delivery"),
    GRAB("grab", "Grab Delivery"),
    ;

    private static final Map<String, ShippingMethodEnum> CODE_TO_ENUM = new HashMap<String, ShippingMethodEnum>();
    static { // Initialize map from legacy code to enum constant
        for (final ShippingMethodEnum code : values()) {
            CODE_TO_ENUM.put(code.getCode(), code);
        }
    }

    private String code;
    private String description;

    private ShippingMethodEnum(final String code, final String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static String getByDescription(String code) {
        for(ShippingMethodEnum e : values()) {
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
        final ShippingMethodEnum CodeEnum = CODE_TO_ENUM.get(code);
        if (CodeEnum == null) {
            //throw new IllegalArgumentException("No enum constant for this code: " + code);
            return false;
        }

        return true;
    }
}