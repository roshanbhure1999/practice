package com.gateway.controller;

import com.gateway.model.AuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/auth")
public class AuthController {


    private final Logger logger = LoggerFactory.getLogger(AuthController.class);


    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OidcUser user,
            Model model
    ) {


        logger.info("user email id : {} ", user.getEmail());

        //creating auth response object
        AuthResponse authResponse = new AuthResponse();

        //setting email to authresponse
        authResponse.setUserId(user.getEmail());

        //setting toke to auth response
        if (Objects.nonNull(client.getAccessToken())) {
            authResponse.setAccessToken(client.getAccessToken().getTokenValue());

            authResponse.setRefreshToken(Objects.requireNonNull(client.getRefreshToken()).getTokenValue());

            authResponse.setExpireAt(Objects.requireNonNull(client.getAccessToken().getExpiresAt()).getEpochSecond());

        }

        List<String> authorities = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());


        authResponse.setAuthorities(authorities);
        logger.info("user {} logged in successfully.", user.getEmail());
        return new ResponseEntity<>(authResponse, HttpStatus.OK);


    }
}
