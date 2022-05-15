package io.meighen_bank_presenter.controller;

import io.meighen_bank_presenter.dto.OkResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainApiController {

    @GetMapping("/ping")
    public ResponseEntity<?> doPongRequest() {
        return ResponseEntity.ok(new OkResponse("Pong"));
    }

    @GetMapping("/private/check_auth")
    public ResponseEntity<?> checkAuth() {
        return ResponseEntity.ok(new OkResponse("Pong"));
    }

}
