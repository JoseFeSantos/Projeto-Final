package projetoFinal.Projeto.Final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projetoFinal.Projeto.Final.model.Endereco;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {

    @Query("SELECT p FROM Endereco p WHERE LOWER(FUNCTION('unaccent', p.rua)) LIKE LOWER(FUNCTION('unaccent', CONCAT('%', :rua, '%')))")
    List<Endereco> buscarPorRua(@Param("rua") String rua);

}
