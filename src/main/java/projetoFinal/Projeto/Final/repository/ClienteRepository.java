package projetoFinal.Projeto.Final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoFinal.Projeto.Final.model.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    List<Cliente> findByNome(String nome);
}
