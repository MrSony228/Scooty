package com.scooty.scooty.repository;

import com.scooty.scooty.table.BankCards;
import liquibase.pro.packaged.id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardsRepository extends JpaRepository<BankCards, id> {
    Boolean existsByNumberBankCards(String numberBankCard);

    Boolean deleteById(int id);

    BankCards getById(int id);
}
