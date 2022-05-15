package io.meighen_bank_presenter.controller;

import io.meighen_bank_presenter.dto.BalanceDto;
import io.meighen_bank_presenter.entity.Card;
import io.meighen_bank_presenter.entity.User;
import io.meighen_bank_presenter.exception.UserNotFoundExeption;
import io.meighen_bank_presenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/private")
public class UserPrivateController {
    @Autowired
    UserService userService;

    private User getAuthentificatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName).orElseThrow(
                () -> {throw new UserNotFoundExeption("");}
        );

        return currentUser;
    }

    @GetMapping("/balance")
    public ResponseEntity<?> getBalance() {
        User u = getAuthentificatedUser();

        float balance = 0;
        for (Card c : u.getCards()) {
            balance += c.getBalance();
        }

        return ResponseEntity.ok(new BalanceDto(balance));
    }
}
