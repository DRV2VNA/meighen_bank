package io.meighen_bank_presenter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.meighen_bank_presenter.dto.CreateCardDto;
import io.meighen_bank_presenter.entity.User;
import io.meighen_bank_presenter.exception.UserNotFoundExeption;
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

        return ResponseEntity.ok(u.getCards());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCard(@RequestBody CreateCardDto createCardDto) throws JsonProcessingException {
        User u = getAuthentificatedUser();

        cardService.createCard(createCardDto, u);
        return ResponseEntity.ok("{\"status\":\"ok\"}");
    }
}
