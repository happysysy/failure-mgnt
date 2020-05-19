package com.lottevn.core.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PayCodeEnum {
    COD("01", "cod", "현금"),
    CREDIT_CARD("02", "credit_card", "카드"),
    CALL_DISCOUNT("03", "discount", "할인"),
    VOUCHER_CASH("04", "voucher_cash", "바우처 + 현금"),
    ATM("05", "atm", "online payment"),
    ZALO("06", "zalo", "social pay"),
    MOMO("07", "momo", "e-wallet"),
    VOUCHER("08", "voucher", "상품권(할인)"),
    LPOINT("09", "lpoint", "엘포인트"),
    ZERO_CODE("10", "zero_code", "제로코드"),
    EMPTY("", "", "");

    private final String payCode;
    private final String methodCode;
    private final String description;

    private PayCodeEnum(String payCode, String methodCode, String description) {
        this.payCode = payCode;
        this.methodCode = methodCode;
        this.description = description;
    }

    public static PayCodeEnum getPayCodeEnumByPayCode(String payCode) {

        return Arrays.stream(PayCodeEnum.values())
                .filter(payCodeEnum -> payCodeEnum.getPayCode().equals(payCode))
                .findAny()
                .orElse(EMPTY);
    }

    public static String getByMethodCode(String code) {
        for(PayCodeEnum e : values()) {
            if(e.getPayCode().equals(code)) return e.getMethodCode();
        }
        return "";
    }
}
