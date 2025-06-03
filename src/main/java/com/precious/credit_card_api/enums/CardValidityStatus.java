package com.precious.credit_card_api.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CardValidityStatus {
    VALID,
    INVALID;

    @JsonValue
    public String getValue() {
        return name().toLowerCase();
    }
}
