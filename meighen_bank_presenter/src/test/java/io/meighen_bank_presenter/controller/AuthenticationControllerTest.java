package io.meighen_bank_presenter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.meighen_bank_presenter.dto.AuthenticationRequestDto;
import io.meighen_bank_presenter.dto.JwtAuthDto;
import io.meighen_bank_presenter.repository.RefreshTokenRepository;
import io.meighen_bank_presenter.repository.RoleRepository;
import io.meighen_bank_presenter.repository.UserRepository;
import io.meighen_bank_presenter.security.JwtTokenProvider;
import io.meighen_bank_presenter.security.JwtUserDetailsService;
import io.meighen_bank_presenter.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthenticationController.class, AuthenticationManager.class, JwtTokenProvider.class,
        UserService.class, JwtUserDetailsService.class})
@ExtendWith(SpringExtension.class)
class AuthenticationControllerTest {

}

