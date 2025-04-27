package projetoFinal.Projeto.Final.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projetoFinal.Projeto.Final.model.Servico;
import projetoFinal.Projeto.Final.repository.ServicoRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public ResponseEntity<?> buscarServicoPorId(String id) {
        try {
            // Busca a servico pelo ID
            Servico servico = servicoRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Servico não encontrada."));

            // Retorna a servico encontrada com status 200 (OK)
            return ResponseEntity.ok(servico);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se a servico não for encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 500 (Internal Server Error) em caso de outros erros
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar a servico: " + e.getMessage());
        }
    }

    public ResponseEntity<?> atualizarServico(String id, Servico servicoAtualizada) {
        try {
            // Verifica se a servico existe
            Servico servicoExistente = servicoRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Servico não encontrada."));

            servicoExistente.setNome(servicoAtualizada.getNome());
            servicoExistente.setDescricao(servicoAtualizada.getDescricao());
            Servico servicoSalva = servicoRepository.save(servicoExistente);

            Map<String, Object> resposta = new HashMap<>();
            resposta.put("servico", servicoSalva);

            // Retorna a resposta com status 200 (OK)
            return ResponseEntity.ok(resposta);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se a servico não for encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 400 (Bad Request) em caso de outros erros
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao atualizar a servico: " + e.getMessage());
        }
    }

    public ResponseEntity<String> deletarServico(String id) { // Use String como tipo do ID
        try {
            // Verifica se a servico existe
            Servico servico = servicoRepository.findById(id) // Use String como tipo do ID
                    .orElseThrow(() -> new EntityNotFoundException("Servico não encontrada."));

            // Se não houver dependências, exclui a servico
            servicoRepository.delete(servico);
            return ResponseEntity.ok("Servico excluída com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}