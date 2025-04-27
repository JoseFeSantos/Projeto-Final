package projetoFinal.Projeto.Final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projetoFinal.Projeto.Final.model.CategoriaServico;

import java.util.List;

public interface CategoriaServicoRepository extends JpaRepository<CategoriaServico, String> {

    boolean existsByNome(String nome);

    @Query("SELECT p FROM CategoriaServico p WHERE LOWER(FUNCTION('unaccent', p.nome)) LIKE LOWER(FUNCTION('unaccent', CONCAT('%', :nome, '%')))")
    List<CategoriaServico> buscarPorNome(@Param("nome") String nome);
}