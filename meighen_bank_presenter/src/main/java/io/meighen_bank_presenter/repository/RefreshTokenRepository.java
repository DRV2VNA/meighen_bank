package io.meighen_bank_presenter.repository;

import io.meighen_bank_presenter.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Refresh token repository.
 */
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
}
