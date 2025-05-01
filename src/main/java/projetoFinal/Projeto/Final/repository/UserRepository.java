package projetoFinal.Projeto.Final.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetoFinal.Projeto.Final.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{

    Optional<User> findByEmail(String email);

}
