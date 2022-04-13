package io.meighen_bank_presenter.controller;


import io.meighen_bank_presenter.dto.UserDto;
import io.meighen_bank_presenter.payload.UserDtoPayload;
import io.meighen_bank_presenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type User signup controller.
 */
@Controller
@RequestMapping("/api/signup")
public class UserSignupController {
    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    /**
     * Sign up new customer response entity.
     *
     * @param userDtoPayload the user dto payload
     * @return the response entity
     */
    @PostMapping("/")
    public ResponseEntity<UserDto> signUpNewCustomer(@RequestBody UserDtoPayload userDtoPayload) {
        UserDto resp = userService.registerNewUser(userDtoPayload);
        return ResponseEntity.ok(resp);
    }


}
