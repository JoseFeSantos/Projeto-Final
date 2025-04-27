package projetoFinal.Projeto.Final.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projetoFinal.Projeto.Final.model.Colaborador;
import projetoFinal.Projeto.Final.repository.ColaboradorRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public ResponseEntity<?> buscarColaboradorPorId(String id) {
        try {
            // Busca o colaborador pelo ID
            Colaborador colaborador = colaboradorRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Colaborador não encontrada."));

            // Retorna o colaborador encontrado com status 200 (OK)
            return ResponseEntity.ok(colaborador);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se o colaborador não for encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 500 (Internal Server Error) em caso de outros erros
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar o colaborador: " + e.getMessage());
        }
    }

    public ResponseEntity<?> atualizarColaborador(String id, Colaborador colaboradorAtualizado) {
        try {
            // Verifica se o colaborador existe
            Colaborador colaboradorExistente = colaboradorRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Colaborador não encontrada."));

            colaboradorExistente.setNome(colaboradorAtualizado.getNome());
            Colaborador colaboradorSalvo = colaboradorRepository.save(colaboradorExistente);

            Map<String, Object> resposta = new HashMap<>();
            resposta.put("colaborador", colaboradorSalvo);

            // Retorna a resposta com status 200 (OK)
            return ResponseEntity.ok(resposta);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se o colaborador não for encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 400 (Bad Request) em caso de outros erros
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao atualizar o colaborador: " + e.getMessage());
        }
    }

    public ResponseEntity<String> deletarColaborador(String id) { // Use String como tipo do ID
        try {
            // Verifica se o colaborador existe
            Colaborador colaborador = colaboradorRepository.findById(id) // Use String como tipo do ID
                    .orElseThrow(() -> new EntityNotFoundException("Colaborador não encontrado."));

            colaboradorRepository.delete(colaborador);
            return ResponseEntity.ok("Colaborador excluído com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}