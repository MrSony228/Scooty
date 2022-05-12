package com.scooty.scooty.services;

import com.scooty.scooty.model.InputBankCard;
import com.scooty.scooty.repository.BankCardsRepository;
import com.scooty.scooty.repository.TransactionRepository;
import com.scooty.scooty.table.BankCard;
import com.scooty.scooty.table.Transaction;
import com.scooty.scooty.table.Travel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final TransactionRepository transactionRepository;
    private final BankCardsRepository bankCardsRepository;

    private final  UsersService usersService;


    //Оплата поездки
    @Transactional
    public Transaction payment(Travel travel, Double sum) {
        Transaction transaction = new Transaction();

        transaction.setTravel(travel);
        transaction.setBankCard(travel.getCard());
        transaction.setSum(sum);
        transaction.setOperationTime(LocalDateTime.now());
        return this.transactionRepository.save(transaction);

    }

    //Поиск по id
    public BankCard getByIdCard(int id) {
        return this.bankCardsRepository.getById(id);
    }

    //Добавление карты
    public List<BankCard> addBankCard(InputBankCard inputBankCard) {
        BankCard bankCard = new BankCard();
        fillBankCard(inputBankCard, bankCard);
        this.bankCardsRepository.save(bankCard);
        return this.bankCardsRepository.getBankCardsByUserId(inputBankCard.getUserId());
    }

    //Удаление карты по id
    public boolean deleteBankCard(int id)
    {
        return this.bankCardsRepository.deleteById(id);
    }

    public Boolean existByNumberBankCard(String number){
        return this.bankCardsRepository.existsByNumberBankCard(number);
    }


    private void fillBankCard(InputBankCard inputBankCard, BankCard bankCard){
        bankCard.setNumberBankCard(inputBankCard.getNumberBankCard());
        bankCard.setCardCvc(inputBankCard.getCardCvc());
        bankCard.setCardDate(inputBankCard.getCardDate());
        bankCard.setUser(usersService.getById(inputBankCard.getUserId()));
    }
}
