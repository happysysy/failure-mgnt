package com.lottevn.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderStateEnum {
    P("P", "cs_confirm", "Call Center Confirm"),
    N("N", "new","New Order"),
    M("M", "accepted", "Accept Order"),
    D("D", "delivery_start", "Delivery Start"),
    E("E", "delivery_complete", "Delivery Complete"),
    F("F", "rejected", "Refuse Order"),
    R("R", "canceled", "Cancel Order"),
    Y("Y", "delivery_request", "Grab Delivery Request"),
    IC("IC", "callcenter_canceled", "callcenter_canceled"),
    IN("IN", "callcenter_new", "callcenter_new")
    ;

    private static final Map<String, OrderStateEnum> CODE_TO_ENUM = new HashMap<String, OrderStateEnum>();
    static { // Initialize map from legacy code to enum constant
        for (final OrderStateEnum code : values()) {
            CODE_TO_ENUM.put(code.getCode(), code);
        }
    }

    private String code;
    private String grsCode;
    private String description;

    private OrderStateEnum(final String code, final String grsCode, final String description) {
        this.code = code;
        this.grsCode = grsCode;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getGrsCode() {
        return grsCode;
    }

    public String getDescription() {
        return description;
    }

    public static String getByGrsCode(String code) {
        for(OrderStateEnum e : values()) {
            if(e.getCode().equals(code)) return e.getGrsCode();
        }
        return "";
    }

    public static String getByCode(String grsCode) {
        for(OrderStateEnum e : values()) {
            if(e.getGrsCode().equals(grsCode)) return e.getCode();
        }
        return "";
    }

    public static String getByDescription(String code) {
        for(OrderStateEnum e : values()) {
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
        final OrderStateEnum CodeEnum = CODE_TO_ENUM.get(code);
        if (CodeEnum == null) {
            //throw new IllegalArgumentException("No enum constant for this code: " + code);
            return false;
        }

        return true;
    }


}
