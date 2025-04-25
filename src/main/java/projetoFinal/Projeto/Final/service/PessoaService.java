package projetoFinal.Projeto.Final.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projetoFinal.Projeto.Final.model.Pessoa;
import projetoFinal.Projeto.Final.repository.PessoaRepository;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvarPessoa(Pessoa pessoa) {
        // Verifica se já existe uma pessoa com o mesmo CPF
        if (pessoaRepository.existsByCpf(pessoa.getCpf())) {
            throw new RuntimeException("Já existe uma pessoa cadastrada com este CPF");
        }
        // Se não existir, salva a pessoa
        return pessoaRepository.save(pessoa);
    }

    public ResponseEntity<?> buscarPessoaPorId(String id) {
        try {
            // Busca a Pessoa pelo ID
            Pessoa pessoa = pessoaRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada."));

            // Retorna a Pessoa encontrada com status 200 (OK)
            return ResponseEntity.ok(pessoa);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se a pessoa não for encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 500 (Internal Server Error) em caso de outros erros
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar a pessoa: " + e.getMessage());
        }
    }

    public ResponseEntity<String> deletarPessoa(String id) { // Use String como tipo do ID
        try {
            // Verifica se a cidade existe
            Pessoa pessoa = pessoaRepository.findById(id) // Use String como tipo do ID
                    .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada."));

            // Se não houver dependências, exclui a cidade
            pessoaRepository.delete(pessoa);
            return ResponseEntity.ok("Pessoa excluída com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    public Pessoa atualizarPessoa(String id, Pessoa pessoa) {
        pessoa.setId((long) Integer.parseInt(id)); // Garante que o ID seja o mesmo
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> buscarPessoaPorNome(String nome) {
        return pessoaRepository.findByNome(nome);
    }

}
