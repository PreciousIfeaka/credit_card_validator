package com.precious.credit_card_api.controllers;


import com.precious.credit_card_api.dtos.CardValidityCheckRequestDto;
import com.precious.credit_card_api.models.Card;
import com.precious.credit_card_api.services.CreditCardValidationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CreditCardValidationController {
    private final CreditCardValidationService creditCardValidationService;

    public CreditCardValidationController(
            CreditCardValidationService creditCardValidationService
    ) {
        this.creditCardValidationService = creditCardValidationService;
    }

    @PostMapping("/validate")
    public ResponseEntity<Card> cardResponseEntity(
            @RequestBody CardValidityCheckRequestDto cardValidityCheckRequestDto
    ) {
        Card cardResponse =
                creditCardValidationService.getCardValidityResponseDetails(
                        cardValidityCheckRequestDto.cardNumber()
                );

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cardResponse);
    }
}
