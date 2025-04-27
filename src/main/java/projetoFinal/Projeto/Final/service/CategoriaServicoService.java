package projetoFinal.Projeto.Final.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projetoFinal.Projeto.Final.model.CategoriaServico;
import projetoFinal.Projeto.Final.repository.CategoriaServicoRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class CategoriaServicoService {

    @Autowired
    private CategoriaServicoRepository categoriaServicoRepository;

    public ResponseEntity<?> buscarCategoriaServicoPorId(String id) {
        try {
            // Busca o categoriaServico pelo ID
            CategoriaServico categoriaServico = categoriaServicoRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("CategoriaServico não encontrada."));

            // Retorna o categoriaServico encontrado com status 200 (OK)
            return ResponseEntity.ok(categoriaServico);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se o categoriaServico não for encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 500 (Internal Server Error) em caso de outros erros
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar o categoriaServico: " + e.getMessage());
        }
    }

    public ResponseEntity<?> atualizarCategoriaServico(String id, CategoriaServico categoriaServicoAtualizado) {
        try {
            // Verifica se o categoriaServico existe
            CategoriaServico categoriaServicoExistente = categoriaServicoRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("CategoriaServico não encontrada."));

            categoriaServicoExistente.setNome(categoriaServicoAtualizado.getNome());
            CategoriaServico categoriaServicoSalvo = categoriaServicoRepository.save(categoriaServicoExistente);

            Map<String, Object> resposta = new HashMap<>();
            resposta.put("categoriaServico", categoriaServicoSalvo);

            // Retorna a resposta com status 200 (OK)
            return ResponseEntity.ok(resposta);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se o categoriaServico não for encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 400 (Bad Request) em caso de outros erros
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao atualizar o categoriaServico: " + e.getMessage());
        }
    }

    public ResponseEntity<String> deletarCategoriaServico(String id) { // Use String como tipo do ID
        try {
            // Verifica se o categoriaServico existe
            CategoriaServico categoriaServico = categoriaServicoRepository.findById(id) // Use String como tipo do ID
                    .orElseThrow(() -> new EntityNotFoundException("CategoriaServico não encontrado."));

            categoriaServicoRepository.delete(categoriaServico);
            return ResponseEntity.ok("CategoriaServico excluído com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}