package com.scooty.scooty.services;

import com.scooty.scooty.repository.BankCardsRepository;
import com.scooty.scooty.repository.TransactionRepository;
import com.scooty.scooty.table.BankCards;
import com.scooty.scooty.table.Transaction;
import com.scooty.scooty.table.Travel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final TransactionRepository transactionRepository;
    private final BankCardsRepository bankCardsRepository;


    //Оплата поездки
    @Transactional
    public Transaction payment(Travel travel, Double sum) {
        Transaction transaction = new Transaction();

        transaction.setTravel(travel);
        transaction.setBankCards(travel.getCard());
        transaction.setSum(sum);
        transaction.setOperationTime(LocalDateTime.now());
        return this.transactionRepository.save(transaction);

    }

    //Поиск по id
    public BankCards getByIdCard(int id) {
        return this.bankCardsRepository.getById(id);
    }

    //Добавление карты
    public BankCards addBankCard(BankCards bankCard) {
        if (bankCardsRepository.existsByNumberBankCards(bankCard.getNumberBankCards())) {
            return null;
        }
        return this.bankCardsRepository.save(bankCard);
    }

    //Удаление карты по id
    public boolean deleteBankCard(int id)
    {
        return this.bankCardsRepository.deleteById(id);
    }
}
