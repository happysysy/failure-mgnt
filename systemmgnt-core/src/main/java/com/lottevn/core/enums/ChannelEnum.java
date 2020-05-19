package com.lottevn.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum ChannelEnum {
    CALL_CENTER("1", "Call Center", "phone_order"),
    PC_WEB("2", "PC Web","online_order"),
    MOBILE_WEB("3", "Mobile Web", "online_order"),
    ANDROID_APP("4", "Android App", "online_order"),
    IPHONE_APP("5", "IPhone App", "online_order"),
    SPEED_L("6", "Speed L", "online_order"),
    LOTTE_VN("7", "Lotte.vn", "online_order")
    ;

    private static final Map<String, ChannelEnum> CODE_TO_ENUM = new HashMap<String, ChannelEnum>();
    static { // Initialize map from legacy code to enum constant
        for (final ChannelEnum code : values()) {
            CODE_TO_ENUM.put(code.getCode(), code);
        }
    }

    private String code;
    private String name;
    private String type;

    private ChannelEnum(final String code, final String grsCode, final String type) {
        this.code = code;
        this.name = grsCode;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public static String getByNamee(String code) {
        for(ChannelEnum e : values()) {
            if(e.getCode().equals(code)) return e.getName();
        }
        return "";
    }

    public static String getByCode(String name) {
        for(ChannelEnum e : values()) {
            if(e.getName().equals(name)) return e.getCode();
        }
        return "";
    }

    public static String getByType(String code) {
        for(ChannelEnum e : values()) {
            if(e.getCode().equals(code)) return e.getType();
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
        final ChannelEnum CodeEnum = CODE_TO_ENUM.get(code);
        if (CodeEnum == null) {
            //throw new IllegalArgumentException("No enum constant for this code: " + code);
            return false;
        }

        return true;
    }


}
