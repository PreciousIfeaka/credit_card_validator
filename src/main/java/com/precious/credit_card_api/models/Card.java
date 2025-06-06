package com.precious.credit_card_api.models;

import com.precious.credit_card_api.enums.CardType;
import com.precious.credit_card_api.enums.CardValidityStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(value = EnumType.STRING)
    private CardType cardType;

    @NotNull
    private String cardNumber;

    @Positive
    private int cardLength;

    @Enumerated(value = EnumType.STRING)
    private CardValidityStatus validityStatus;
}
