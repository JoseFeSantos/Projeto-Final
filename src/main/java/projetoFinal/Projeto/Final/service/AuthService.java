package projetoFinal.Projeto.Final.service;

import projetoFinal.Projeto.Final.model.User;
import projetoFinal.Projeto.Final.dtos.LoginRequestDTO;
import projetoFinal.Projeto.Final.dtos.ResponseDTO;
import projetoFinal.Projeto.Final.dtos.RegisterRequestDTO;
import projetoFinal.Projeto.Final.infra.security.TokenService;
import projetoFinal.Projeto.Final.repository.UserRepository;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public ResponseEntity<?> login(LoginRequestDTO body) {
        if (body.email() == null || body.email().isEmpty()) {
            return ResponseEntity.badRequest().body("Email é obrigatório");
        }

        if (body.password() == null || body.password().isEmpty()) {
            return ResponseEntity.badRequest().body("Senha é obrigatória");
        }

        Optional<User> userOptional = this.userRepository.findByEmail(body.email());


        if (userOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuário não cadastrado");
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(body.password(), user.getPassword())) {
            return ResponseEntity.badRequest().body("Senha inválida");
        }

        String token = this.tokenService.generateToken(user);
        return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
    }

    public ResponseEntity<?> register(RegisterRequestDTO body) {
        Optional<User> user = this.userRepository.findByEmail(body.email());

        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setPhone(body.phone());
            newUser.setName(body.name());
            this.userRepository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));
        }

        return ResponseEntity.badRequest().body("Usuário já cadastrado");
    }
}