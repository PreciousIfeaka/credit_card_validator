package com.precious.credit_card_api.repositories;

import com.precious.credit_card_api.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
}
