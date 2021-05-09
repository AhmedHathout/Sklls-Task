package com.ahmedhathout.skllstask.controllers;

import com.ahmedhathout.skllstask.entities.User;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/validatelogin")
@AllArgsConstructor
@Log4j2
public class ValidateLoginController {

    @PostMapping
    public ResponseEntity<User> validateLogin(@AuthenticationPrincipal User user) {
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
