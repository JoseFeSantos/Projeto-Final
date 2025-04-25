package projetoFinal.Projeto.Final.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projetoFinal.Projeto.Final.model.Cidade;
import projetoFinal.Projeto.Final.repository.CidadeRepository;
import projetoFinal.Projeto.Final.repository.PessoaRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class CidadeService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    public ResponseEntity<?> buscarCidadePorId(String id) {
        try {
            // Busca a cidade pelo ID
            Cidade cidade = cidadeRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada."));

            // Retorna a cidade encontrada com status 200 (OK)
            return ResponseEntity.ok(cidade);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se a cidade não for encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 500 (Internal Server Error) em caso de outros erros
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar a cidade: " + e.getMessage());
        }
    }

    public ResponseEntity<?> atualizarCidade(String id, Cidade cidadeAtualizada) {
        try {
            // Verifica se a cidade existe
            Cidade cidadeExistente = cidadeRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada."));

            cidadeExistente.setNome(cidadeAtualizada.getNome());
            Cidade cidadeSalva = cidadeRepository.save(cidadeExistente);

            Map<String, Object> resposta = new HashMap<>();
            resposta.put("cidade", cidadeSalva);

            // Retorna a resposta com status 200 (OK)
            return ResponseEntity.ok(resposta);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se a cidade não for encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 400 (Bad Request) em caso de outros erros
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao atualizar a cidade: " + e.getMessage());
        }
    }

    public ResponseEntity<String> deletarCidade(String id) { // Use String como tipo do ID
        try {
            // Verifica se a cidade existe
            Cidade cidade = cidadeRepository.findById(id) // Use String como tipo do ID
                    .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada."));

            // Verifica se há pessoas vinculadas à cidade
            if (pessoaRepository.existsByCidadeId(Integer.valueOf(id))) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Não é possível excluir a cidade, pois há pessoas vinculadas.");
            }

            // Se não houver dependências, exclui a cidade
            cidadeRepository.delete(cidade);
            return ResponseEntity.ok("Cidade excluída com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}