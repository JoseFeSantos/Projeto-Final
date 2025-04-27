package projetoFinal.Projeto.Final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projetoFinal.Projeto.Final.model.Cidade;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, String> {

    boolean existsByEstadoId(int id);

    @Query("SELECT p FROM Cidade p WHERE LOWER(FUNCTION('unaccent', p.nome)) LIKE LOWER(FUNCTION('unaccent', CONCAT('%', :nome, '%')))")
    List<Cidade> buscarPorNome(@Param("nome") String nome);
}
