package com.precious.credit_card_api.services;

import com.precious.credit_card_api.enums.CardType;
import com.precious.credit_card_api.enums.CardValidityStatus;
import com.precious.credit_card_api.models.Card;
import org.springframework.stereotype.Service;

@Service
public class CreditCardValidationService {
    private CardValidityStatus getCardValidity(String cardNumber) {
        int evenSum = 0;
        int oddSum = 0;
        int cardLength = cardNumber.length();
        for (int i = 0; i < cardLength; i++) {
            int digitVal = Character.getNumericValue(cardNumber.charAt(cardLength - i - 1));

            if (i % 2 == 0) evenSum += digitVal;
            else {
                oddSum += (digitVal * 2) < 10 ? (digitVal * 2) : (digitVal * 2) - 9;
            }
        }

        if ((evenSum + oddSum) % 10 == 0) return CardValidityStatus.VALID;
        return CardValidityStatus.INVALID;
    }

    private CardType getCardType(String cardNumber) {
        CardType cardType;

        if (cardNumber.length() > 16 || cardNumber.length() < 13) cardType = CardType.INVALID_CARD;
        else if (cardNumber.startsWith("4")) cardType = CardType.VISA;
        else if (cardNumber.startsWith("5")) cardType = CardType.MASTERCARD;
        else if (cardNumber.startsWith("37")) cardType = CardType.AMERICAN_EXPRESS;
        else if (cardNumber.startsWith("6")) cardType = CardType.DISCOVER;
        else cardType = CardType.INVALID_CARD;

        return cardType;
    }

    public Card getCardValidityResponseDetails(String cardNumber) {
        CardType cardType = this.getCardType(cardNumber);
        int cardLength = cardNumber.length();
        CardValidityStatus cardValidityStatus = this.getCardValidity(cardNumber);

        return new Card(cardType, cardNumber, cardLength, cardValidityStatus);
    }
}
