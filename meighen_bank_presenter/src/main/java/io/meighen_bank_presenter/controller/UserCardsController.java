package io.meighen_bank_presenter.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.meighen_bank_presenter.dto.*;
import io.meighen_bank_presenter.entity.Card;
import io.meighen_bank_presenter.entity.Transaction;
import io.meighen_bank_presenter.entity.User;
import io.meighen_bank_presenter.exception.UserNotFoundExeption;
import io.meighen_bank_presenter.payload.TransactionsPayload;
import io.meighen_bank_presenter.repository.TransactionRepository;
import io.meighen_bank_presenter.service.CardService;
import io.meighen_bank_presenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/cards")
public class UserCardsController {
    @Autowired
    private UserService userService;

    @Autowired
    CardService cardService;

    @Autowired
    TransactionRepository transactionRepository;

    private User getAuthentificatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName).orElseThrow(
                () -> {throw new UserNotFoundExeption("");}
        );

        return currentUser;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getCardsByUser() {
        User u = getAuthentificatedUser();

        return ResponseEntity.ok(new AllCardsDto(u.getCards()));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCard(@RequestBody CreateCardDto createCardDto) throws JsonProcessingException {
        User u = getAuthentificatedUser();

        cardService.createCard(createCardDto, u);
        return ResponseEntity.ok("{\"status\":\"ok\"}");
    }

    @PostMapping("/transaction")
    public ResponseEntity<?> createTransaction(@RequestBody TransactionDto transactionDto) throws JsonProcessingException {
        User u = getAuthentificatedUser();

        cardService.doIntCardTransaction(transactionDto, u);
        return ResponseEntity.ok("{\"status\":\"ok\"}");
    }

    @GetMapping("/transaction")
    public ResponseEntity<?> showAllTransactions() {
        User u = getAuthentificatedUser();

        List<Transaction> transactionList = new ArrayList<>();
        for (Card card: u.getCards()) {
            transactionList.addAll(transactionRepository.findAllBySendFrom(card.getCard_number()));
            transactionList.addAll(transactionRepository.findAllBySendTo(card.getCard_number()));
        }


        return ResponseEntity.ok(new TransactionsPayload(transactionList));
    }

    @GetMapping("/transaction/daily")
    public ResponseEntity<?> showDailyTransactions(@RequestBody DailyTransactionsDto dailyTransactionsDto) throws ParseException {
        User u = getAuthentificatedUser();

        String dateBefore = dailyTransactionsDto.getTransactionDate().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNewBefore = sdf.parse(dailyTransactionsDto.getTransactionDate());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateNewBefore);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        String dateAfter = sdf.format(calendar.getTime());
        Date dateNewAfter = sdf.parse(dateAfter);


        System.out.println(dateNewAfter);

        List<Transaction> transactionList = new ArrayList<>();
        for (Card card: u.getCards()) {
            transactionList.addAll(transactionRepository.findAllBySendFromAndPerformedBetween(card.getCard_number(), dateNewBefore, dateNewAfter));
            transactionList.addAll(transactionRepository.findAllBySendToAndPerformedBetween(card.getCard_number(), dateNewBefore, dateNewAfter));
        }


        return ResponseEntity.ok(new TransactionsPayload(transactionList));
    }
}
