package io.meighen_bank_operationer;

import java.io.IOException;
import java.text.ParseException;

import io.meighen_bank_operationer.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restfull {
    @Autowired
    CardService cardService;

    @GetMapping("/generate")
    public ResponseEntity<?> generate(@RequestParam String email) throws IOException, ParseException {
        cardService.createCard(email);
        return ResponseEntity.ok("ok");
    }
}
