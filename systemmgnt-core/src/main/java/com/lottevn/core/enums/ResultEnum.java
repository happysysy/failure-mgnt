package com.lottevn.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum ResultEnum {
    SUCCESS("SUCCESS", "Success", 0),
    FAIL("FAIL", "Fail", 419),
    NODATA("NODATA", "No Data", 413),
    NOAUTHORIZED("NOAUTHORIZED", "No authorized Token", 419)
    ;

    private static final Map<String, ResultEnum> CODE_TO_ENUM = new HashMap<String, ResultEnum>();
    static { // Initialize map from legacy code to enum constant
        for (final ResultEnum code : values()) {
            CODE_TO_ENUM.put(code.getCode(), code);
        }
    }

    private String code;
    private String description;
    private Integer grsErrorCode;

    private ResultEnum(final String code, final String description, final Integer grsErrorCode) {
        this.code = code;
        this.description = description;
        this.grsErrorCode = grsErrorCode;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Integer getGrsErrorCode() {
        return grsErrorCode;
    }

    public static String getByDescription(String code) {
        for(ResultEnum e : values()) {
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
        final ResultEnum CodeEnum = CODE_TO_ENUM.get(code);
        if (CodeEnum == null) {
            //throw new IllegalArgumentException("No enum constant for this code: " + code);
            return false;
        }

        return true;
    }
}