package projetoFinal.Projeto.Final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoFinal.Projeto.Final.model.Colaborador;

import java.util.List;

public interface ColaboradorRepository extends JpaRepository<Colaborador, String> {

    List<Colaborador> findByNome(String nome);

    boolean existsByCpf(long cpf);
}
