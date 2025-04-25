package projetoFinal.Projeto.Final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projetoFinal.Projeto.Final.model.Estado;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, String> {

    List<Estado> findByNome(String nome);

    boolean existsByNome(String nome);

    @Query("SELECT p FROM Estado p WHERE LOWER(FUNCTION('unaccent', p.nome)) LIKE LOWER(FUNCTION('unaccent', CONCAT('%', :nome, '%')))")
    List<Estado> buscarPorNome(@Param("nome") String nome);
}