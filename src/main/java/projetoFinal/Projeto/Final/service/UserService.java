package projetoFinal.Projeto.Final.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import projetoFinal.Projeto.Final.model.User;
import projetoFinal.Projeto.Final.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("sucesso!");
    }

    public ResponseEntity<User> getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());

        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
}
