package projetoFinal.Projeto.Final.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projetoFinal.Projeto.Final.model.Pessoa;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, String> {

    List<Pessoa> findByNome(String nome);

    boolean existsByCpf(long cpf);

    @Autowired
    boolean existsByCidadeId(Integer id);

    @Query("SELECT p FROM Pessoa p WHERE LOWER(FUNCTION('unaccent', p.nome)) LIKE LOWER(FUNCTION('unaccent', CONCAT('%', :nome, '%')))")
    List<Pessoa> buscarPorNome(@Param("nome") String nome);
}