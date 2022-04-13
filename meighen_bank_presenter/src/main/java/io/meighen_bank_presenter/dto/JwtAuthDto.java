package io.meighen_bank_presenter.dto;

import lombok.Data;

/**
 * The type Jwt auth dto.
 */
@Data
public class JwtAuthDto {
    private String username;
    private String accessToken;
    private String refreshToken;
}
