package io.meighen_bank_presenter.dto;

import lombok.Data;

/**
 * The type Authentication request dto.
 */
@Data
public class AuthenticationRequestDto {
    private String email;
    private String password;
}
