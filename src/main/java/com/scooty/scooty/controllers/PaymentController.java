package com.scooty.scooty.controllers;

import com.scooty.scooty.controllers.model.NetworkAnswer;
import com.scooty.scooty.model.InputBankCard;
import com.scooty.scooty.services.PaymentService;
import com.scooty.scooty.services.UsersService;
import com.scooty.scooty.table.BankCard;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private final PaymentService paymentService;

    @Autowired
    private final UsersService usersService;

    @PostMapping("/add")
    public List<BankCard> addCard(@RequestBody InputBankCard inputBankCard, HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        inputBankCard.setUserId(usersService.getUserIdByEmail(principal.getName()));
        return paymentService.addBankCard(inputBankCard);
    }

    @GetMapping("/check-exist")
    public NetworkAnswer<Boolean> checkEmail(@RequestParam(name = "numberBankCard") String numberBankCard) {
        return new NetworkAnswer<>(this.paymentService.existByNumberBankCard(numberBankCard));
    }

}
