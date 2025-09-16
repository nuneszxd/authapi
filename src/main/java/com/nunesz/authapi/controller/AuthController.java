package com.nunesz.authapi.controller;


import com.nunesz.authapi.dto.LoginRequest;
import com.nunesz.authapi.dto.RegisterRequest;
import com.nunesz.authapi.entity.User;
import com.nunesz.authapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request){
        User user = userService.register(request);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
        String message = userService.login(request);
        return ResponseEntity.ok(message);
    }


}
