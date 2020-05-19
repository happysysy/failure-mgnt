package com.lottevn.core.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PaymentMethodEnum {

    COD("cod", "1", "", "Cash(On-Site)"),
    CARD("credit_card", "0", "2","Credit card"),
    ATM("atm", "4", "", "online payment"),
    ZALO("zalo", "4", "","online payment"),
    MOMO("momo", "4", "","online payment"),
    ZERO("zero_code", "3", "","Voucher and Cash"),
    EMPTY("", "", "", "");

    private final String payCode;
    private final String codeValue;
    private final String preCodeValue;
    private final String description;

    private PaymentMethodEnum(String payCode, String codeValue, String preCodeValue, String description) {
        this.payCode = payCode;
        this.codeValue = codeValue;
        this.preCodeValue = preCodeValue;
        this.description = description;
    }

    public static PaymentMethodEnum getCodeValueByPayCode(String payCode) {

        return Arrays.stream(PaymentMethodEnum.values())
                .filter(paymentMethodEnum -> paymentMethodEnum.getPayCode().equals(payCode))
                .findAny()
                .orElse(EMPTY);
    }


}
