package com.nunesz.authapi.service;

import com.nunesz.authapi.dto.LoginRequest;
import com.nunesz.authapi.dto.RegisterRequest;
import com.nunesz.authapi.entity.User;
import com.nunesz.authapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.core.RepositoryCreationException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User register(RegisterRequest request){
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
        return userRepository.save(user);
    }

    public String login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        if (!user.getPassword().equals(request.getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Senha incorreta");
        }

        return "Login realizado com sucesso!";
    }


}
