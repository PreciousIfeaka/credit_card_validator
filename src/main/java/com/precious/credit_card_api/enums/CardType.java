package com.precious.credit_card_api.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CardType {
    MASTERCARD,
    VISA,
    AMERICAN_EXPRESS,
    DISCOVER,
    INVALID_CARD;

    @JsonValue
    public String getValue() {
        String[] strArr = name().toLowerCase().split("_");
        if (strArr.length == 2) return String.join(" ", strArr);
        else return strArr[0];
    }
}
