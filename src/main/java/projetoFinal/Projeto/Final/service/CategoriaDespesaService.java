package projetoFinal.Projeto.Final.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projetoFinal.Projeto.Final.model.CategoriaDespesa;
import projetoFinal.Projeto.Final.model.CategoriaServico;
import projetoFinal.Projeto.Final.repository.CategoriaDespesaRepository;
import projetoFinal.Projeto.Final.repository.CategoriaServicoRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class CategoriaDespesaService {

    @Autowired
    private CategoriaDespesaRepository categoriaDespesaRepository;

    public ResponseEntity<?> buscarCategoriaDespesaPorId(String id) {
        try {
            // Busca o categoriaDespesa pelo ID
            CategoriaDespesa categoriaDespesa = categoriaDespesaRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("CategoriaDespesa não encontrada."));

            // Retorna o categoriaServico encontrado com status 200 (OK)
            return ResponseEntity.ok(categoriaDespesa);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se o categoriaDespesa não for encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 500 (Internal Server Error) em caso de outros erros
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar o categoriaDespesa: " + e.getMessage());
        }
    }

    public ResponseEntity<?> atualizarCategoriaDespesa(String id, CategoriaDespesa categoriaDespesaAtualizado) {
        try {
            // Verifica se o categoriaDespesa existe
            CategoriaDespesa categoriaDespesaExistente = categoriaDespesaRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("CategoriaDespeesa não encontrada."));

            categoriaDespesaExistente.setNome(categoriaDespesaAtualizado.getNome());
            CategoriaDespesa categoriaDespesaSalvo = categoriaDespesaRepository.save(categoriaDespesaExistente);

            Map<String, Object> resposta = new HashMap<>();
            resposta.put("categoriaDespesa", categoriaDespesaSalvo);

            // Retorna a resposta com status 200 (OK)
            return ResponseEntity.ok(resposta);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se o categoriaDespesa não for encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 400 (Bad Request) em caso de outros erros
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao atualizar o categoriaDespesa: " + e.getMessage());
        }
    }

    public ResponseEntity<String> deletarCategoriaDespesa(String id) { // Use String como tipo do ID
        try {
            // Verifica se o categoriaDespesa existe
            CategoriaDespesa categoriaDespesa = categoriaDespesaRepository.findById(id) // Use String como tipo do ID
                    .orElseThrow(() -> new EntityNotFoundException("CategoriaDespesa não encontrado."));

            categoriaDespesaRepository.delete(categoriaDespesa);
            return ResponseEntity.ok("CategoriaDespesa excluído com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}