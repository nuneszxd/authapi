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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public User register(RegisterRequest request){
        String senhaCriptografada = encoder.encode(request.getPassword());

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(senhaCriptografada)
                .build();
        return userRepository.save(user);
    }

    public String login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        if (!encoder.matches(request.getPassword(), user.getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Senha incorreta");
        }

        return "Login realizado com sucesso!";
    }


}
