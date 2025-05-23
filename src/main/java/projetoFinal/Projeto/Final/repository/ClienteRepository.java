package projetoFinal.Projeto.Final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projetoFinal.Projeto.Final.model.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query("SELECT p FROM Cliente p WHERE LOWER(FUNCTION('unaccent', p.nome)) LIKE LOWER(FUNCTION('unaccent', CONCAT('%', :nome, '%')))")
    List<Cliente> buscarPorNome(@Param("nome") String nome);
}
