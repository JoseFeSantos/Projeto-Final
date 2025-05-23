package projetoFinal.Projeto.Final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projetoFinal.Projeto.Final.model.CategoriaDespesa;
import java.util.List;

public interface CategoriaDespesaRepository extends JpaRepository<CategoriaDespesa, String> {

    boolean existsByNome(String nome);

    @Query("SELECT p FROM CategoriaDespesa p WHERE LOWER(FUNCTION('unaccent', p.nome)) LIKE LOWER(FUNCTION('unaccent', CONCAT('%', :nome, '%')))")
    List<CategoriaDespesa> buscarPorNome(@Param("nome") String nome);
}