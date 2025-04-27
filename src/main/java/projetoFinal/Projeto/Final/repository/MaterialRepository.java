package projetoFinal.Projeto.Final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projetoFinal.Projeto.Final.model.Material;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, String> {

    List<Material> findByNome(String nome);

    boolean existsByNome(String nome);

    @Query("SELECT p FROM Material p WHERE LOWER(FUNCTION('unaccent', p.nome)) LIKE LOWER(FUNCTION('unaccent', CONCAT('%', :nome, '%')))")
    List<Material> buscarPorNome(@Param("nome") String nome);

}