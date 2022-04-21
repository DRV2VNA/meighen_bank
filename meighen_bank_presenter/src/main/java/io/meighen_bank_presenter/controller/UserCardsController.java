package io.meighen_bank_presenter.controller;

import io.meighen_bank_presenter.entity.User;
import io.meighen_bank_presenter.exception.UserNotFoundExeption;
import io.meighen_bank_presenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/cards")
public class UserCardsController {
    @Autowired
    private UserService userService;

    private User getAuthentificatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName).orElseThrow(
                () -> {throw new UserNotFoundExeption("");}
        );

        return currentUser;
    }

    public ResponseEntity<?> getCardsByUser() {
        User u = getAuthentificatedUser();

        return ResponseEntity.ok(u.getCards());
    }
}
