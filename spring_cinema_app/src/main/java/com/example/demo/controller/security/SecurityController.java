package com.example.demo.controller.security;

import com.example.demo.dto.reponse.JwtReponse;
import com.example.demo.dto.reponse.MessageReponse;
import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.ResetPasswordRequest;
import com.example.demo.dto.request.TokenDto;
import com.example.demo.dto.request.VerifyRequest;
import com.example.demo.jwt.JwtTokenProvider;
import com.example.demo.model.account.Account;
import com.example.demo.service.impl.account.AccountService;
import com.example.demo.service.impl.account.JwtAccountDetailsImpl;
import com.example.demo.service.impl.account.RoleService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityController {

    @Value("${google.clientId}")
    String googleCilentId;

    @Autowired
    private RoleService roleService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<JwtReponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(loginRequest.getUsername());
        JwtAccountDetailsImpl userDetails = (JwtAccountDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        return ResponseEntity.ok(new JwtReponse( jwt,
                userDetails.getUsername(),
                roles));
    }


    @PostMapping("/login-social")
    public ResponseEntity<JwtReponse> socialLogin(@RequestBody TokenDto jwtSocial) throws IOException {
        final NetHttpTransport netHttpTransport = new NetHttpTransport();
        final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier.Builder builder =
                new GoogleIdTokenVerifier.Builder(netHttpTransport, jacksonFactory)
                        .setAudience(Collections.singletonList(googleCilentId));
        try {
            final GoogleIdToken googleIdToken = GoogleIdToken.parse(builder.getJsonFactory(), jwtSocial.getValue());
            final GoogleIdToken.Payload payload = googleIdToken.getPayload();
            Optional<Account> accountOptional = accountService.findByUsername(payload.getEmail());

            if (!accountOptional.isPresent()) {
                Account account = new Account();
                account.setUsername(payload.getEmail());
                accountService.save(account);
                roleService.setDefaultRole(payload.getEmail(), 3);
            }

            String jwt = jwtTokenProvider.generateToken(payload.getEmail());

            JwtAccountDetailsImpl userDetails = (JwtAccountDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

            return ResponseEntity.ok(new JwtReponse( jwt,
                    userDetails.getUsername(),
                    roles));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/verify")
    public ResponseEntity<MessageReponse> VerifyEmail(@RequestBody VerifyRequest code) {
        Boolean isVerified = accountService.findAccountByVerificationCode(code.getCode());
        if (isVerified) {
            return ResponseEntity.ok(new MessageReponse("activated"));
        } else {
            return ResponseEntity.ok(new MessageReponse("error"));
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<MessageReponse> reset(@RequestBody LoginRequest loginRequest) throws MessagingException, UnsupportedEncodingException {
        if (accountService.existsAccountByUsername(loginRequest.getUsername()) != null) {
            accountService.addVerificationCode(loginRequest.getUsername());
            return ResponseEntity.ok(new MessageReponse("Sent Email: "));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageReponse("Tài khoản không chính xác."));
    }

    @PostMapping("/verify-password")
    public ResponseEntity<MessageReponse> verifyPassword(@RequestBody VerifyRequest code) {
        Boolean isVerified = accountService.findAccountByVerificationCodeToResetPassword(code.getCode());
        if (isVerified) {
            return ResponseEntity.ok(new MessageReponse("accepted"));
        } else {
            return ResponseEntity.ok(new MessageReponse("error"));
        }
    }

    @PostMapping("/has-reset-password")
    public ResponseEntity<MessageReponse> hasResetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        accountService.saveNewPassword(passwordEncoder.encode(resetPasswordRequest.getPassword()), resetPasswordRequest.getCode());
        return ResponseEntity.ok(new MessageReponse("Success"));
    }
}
