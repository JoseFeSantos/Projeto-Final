package projetoFinal.Projeto.Final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projetoFinal.Projeto.Final.model.DadosBancarios;

import java.util.List;

public interface DadosBancariosRepository extends JpaRepository<DadosBancarios, Long> {

    List<DadosBancarios> findByNome(String nome);

    @Query("SELECT p FROM DadosBancarios p WHERE LOWER(FUNCTION('unaccent', p.nome)) LIKE LOWER(FUNCTION('unaccent', CONCAT('%', :nome, '%')))")
    List<DadosBancarios> buscarPorNome(@Param("nome") String nome);

}