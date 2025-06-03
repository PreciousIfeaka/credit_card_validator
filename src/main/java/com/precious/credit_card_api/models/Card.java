package com.precious.credit_card_api.models;

import com.precious.credit_card_api.enums.CardType;
import com.precious.credit_card_api.enums.CardValidityStatus;

public class Card {
    private final CardType cardType;
    private final String cardNumber;
    private final int cardLength;
    private final CardValidityStatus validityStatus;

    public Card(
            CardType cardType,
            String cardNumber,
            int cardLength,
            CardValidityStatus validityStatus
    ) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardLength = cardLength;
        this.validityStatus = validityStatus;
    }

    public CardType getCardType() {
        return cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getCardLength() {
        return cardLength;
    }

    public CardValidityStatus getValidityStatus() {
        return validityStatus;
    }
}
