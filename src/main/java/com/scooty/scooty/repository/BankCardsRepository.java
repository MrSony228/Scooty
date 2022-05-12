package com.scooty.scooty.repository;

import com.scooty.scooty.table.BankCard;
import liquibase.pro.packaged.id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankCardsRepository extends JpaRepository<BankCard, id> {
    Boolean existsByNumberBankCard(String numberBankCard);

    Boolean deleteById(int id);

    BankCard getById(int id);

    List<BankCard> getBankCardsByUserId(int userId);
}
