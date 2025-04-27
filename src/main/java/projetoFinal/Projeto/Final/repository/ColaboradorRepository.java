package projetoFinal.Projeto.Final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projetoFinal.Projeto.Final.model.Colaborador;

import java.util.List;

public interface ColaboradorRepository extends JpaRepository<Colaborador, String> {

    boolean existsByCpf(String cpf);

    @Query("SELECT p FROM Colaborador p WHERE LOWER(FUNCTION('unaccent', p.nome)) LIKE LOWER(FUNCTION('unaccent', CONCAT('%', :nome, '%')))")
    List<Colaborador> buscarPorNome(@Param("nome") String nome);

}
