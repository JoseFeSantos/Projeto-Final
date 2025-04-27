package projetoFinal.Projeto.Final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projetoFinal.Projeto.Final.model.Servico;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, String> {

    boolean existsByNome(String nome);

    @Query("SELECT p FROM Servico p WHERE LOWER(FUNCTION('unaccent', p.nome)) LIKE LOWER(FUNCTION('unaccent', CONCAT('%', :nome, '%')))")
    List<Servico> buscarPorNome(@Param("nome") String nome);
}