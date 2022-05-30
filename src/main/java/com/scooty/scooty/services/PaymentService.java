package com.scooty.scooty.services;

import com.scooty.scooty.model.InputBankCard;
import com.scooty.scooty.repository.BankCardsRepository;
import com.scooty.scooty.repository.TransactionRepository;
import com.scooty.scooty.table.BankCard;
import com.scooty.scooty.table.Transaction;
import com.scooty.scooty.table.Travel;
import liquibase.pro.packaged.I;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

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
    public BankCard getById(int id) {
        return this.bankCardsRepository.getById(id);
    }

    public List<InputBankCard> getByUserId(int id) {
        List<BankCard> cards =bankCardsRepository.getBankCardsByUserId(id);
        if(cards.isEmpty()){
            return null;
        }
        List<InputBankCard> result = new ArrayList<>();
        if(cards.size() == 1){
            InputBankCard card = new InputBankCard();
            card.setUserId(cards.get(0).getUser().getId());
            card.setNumberBankCard(cards.get(0).getNumberBankCard());
            card.setCardDate(cards.get(0).getCardDate());
            card.setCardCvc(cards.get(0).getCardCvc());
            result.add(0, card);
        }
        else {
            for (int i = 0; i <= cards.size(); i++) {
                InputBankCard card = new InputBankCard();
                card.setUserId(cards.get(i).getUser().getId());
                card.setNumberBankCard(cards.get(i).getNumberBankCard());
                card.setCardDate(cards.get(i).getCardDate());
                card.setCardCvc(cards.get(i).getCardCvc());
                result.add(i, card);
            }
        }
        return result;
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
