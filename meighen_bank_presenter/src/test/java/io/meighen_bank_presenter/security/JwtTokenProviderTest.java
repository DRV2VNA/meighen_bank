package io.meighen_bank_presenter.security;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.jsonwebtoken.JwtException;
import io.meighen_bank_presenter.entity.RefreshToken;
import io.meighen_bank_presenter.entity.Role;
import io.meighen_bank_presenter.entity.User;
import io.meighen_bank_presenter.repository.RefreshTokenRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class JwtTokenProviderTest {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    private RefreshTokenRepository refreshTokenRepository;

    /**
     * Method under test: {@link JwtTokenProvider#createRefreshToken(long)}
     */
    @Test
    void testCreateRefreshToken() {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setRefreshToken("ABC123");
        refreshToken.setUserId(123L);
        when(this.refreshTokenRepository.save((RefreshToken) any())).thenReturn(refreshToken);
        this.jwtTokenProvider.createRefreshToken(1L);
        verify(this.refreshTokenRepository).save((RefreshToken) any());
    }

    /**
     * Method under test: {@link JwtTokenProvider#createRefreshToken(long)}
     */
    @Test
    void testCreateRefreshToken2() {
        when(this.refreshTokenRepository.save((RefreshToken) any())).thenThrow(new JwtException("An error occurred"));
        assertThrows(JwtException.class, () -> this.jwtTokenProvider.createRefreshToken(1L));
        verify(this.refreshTokenRepository).save((RefreshToken) any());
    }

    /**
     * Method under test: {@link JwtTokenProvider#resolveAccessToken(javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testResolveAccessToken() {
        assertNull(this.jwtTokenProvider.resolveAccessToken(new MockHttpServletRequest()));
    }

    /**
     * Method under test: {@link JwtTokenProvider#validateAccessToken(String)}
     */
    @Test
    void testValidateAccessToken() {
        assertFalse(this.jwtTokenProvider.validateAccessToken("ABC123"));
        assertFalse(this.jwtTokenProvider.validateAccessToken(""));
        assertFalse(this.jwtTokenProvider.validateAccessToken("io.jsonwebtoken.Claims"));
        assertFalse(this.jwtTokenProvider.validateAccessToken("io.meighen_bank_presenter.entity.User"));
    }

    /**
     * Method under test: {@link JwtTokenProvider#validateRefreshToken(String)}
     */
    @Test
    void testValidateRefreshToken() {
        assertFalse(this.jwtTokenProvider.validateRefreshToken("ABC123"));
        assertFalse(this.jwtTokenProvider.validateRefreshToken(""));
        assertFalse(this.jwtTokenProvider.validateRefreshToken("io.jsonwebtoken.Claims"));
        assertFalse(this.jwtTokenProvider.validateRefreshToken("io.meighen_bank_presenter.entity.User"));
    }

    /**
     * Method under test: {@link JwtTokenProvider#refreshPairOfTokens(String)}
     */
    @Test
    void testRefreshPairOfTokens() {
        assertThrows(IllegalArgumentException.class, () -> this.jwtTokenProvider.refreshPairOfTokens("ABC123"));
        assertThrows(IllegalArgumentException.class, () -> this.jwtTokenProvider.refreshPairOfTokens(""));
        assertThrows(IllegalArgumentException.class,
                () -> this.jwtTokenProvider.refreshPairOfTokens("io.jsonwebtoken.Claims"));
        assertThrows(IllegalArgumentException.class,
                () -> this.jwtTokenProvider.refreshPairOfTokens("io.meighen_bank_presenter.entity.User"));
    }
}

