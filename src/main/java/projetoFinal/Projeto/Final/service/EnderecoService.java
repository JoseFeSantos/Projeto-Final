package projetoFinal.Projeto.Final.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projetoFinal.Projeto.Final.model.Endereco;
import projetoFinal.Projeto.Final.repository.EnderecoRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public ResponseEntity<?> buscarEnderecoPorId(String id) {
        try {
            // Busca a endereco pelo ID
            Endereco endereco = enderecoRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Endereco não encontrada."));

            // Retorna a endereco encontrada com status 200 (OK)
            return ResponseEntity.ok(endereco);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se a endereco não for encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 500 (Internal Server Error) em caso de outros erros
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar a endereco: " + e.getMessage());
        }
    }

    public ResponseEntity<?> atualizarEndereco(String id, Endereco enderecoAtualizada) {
        try {
            // Verifica se a endereco existe
            Endereco enderecoExistente = enderecoRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Endereco não encontrada."));

            enderecoExistente.setCep(enderecoAtualizada.getCep());
            enderecoExistente.setCliente(enderecoAtualizada.getCliente());
            enderecoExistente.setCidade(enderecoAtualizada.getCidade());
            enderecoExistente.setComplemento(enderecoAtualizada.getComplemento());
            enderecoExistente.setDistrito(enderecoAtualizada.getDistrito());
            enderecoExistente.setEstado(enderecoAtualizada.getEstado());
            enderecoExistente.setNumero(enderecoAtualizada.getNumero());
            enderecoExistente.setRua(enderecoAtualizada.getRua());
            Endereco enderecoSalva = enderecoRepository.save(enderecoExistente);

            Map<String, Object> resposta = new HashMap<>();
            resposta.put("endereco", enderecoSalva);

            // Retorna a resposta com status 200 (OK)
            return ResponseEntity.ok(resposta);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se a endereco não for encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 400 (Bad Request) em caso de outros erros
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao atualizar a endereco: " + e.getMessage());
        }
    }

    public ResponseEntity<String> deletarEndereco(String id) { // Use String como tipo do ID
        try {
            // Verifica se a endereco existe
            Endereco endereco = enderecoRepository.findById(id) // Use String como tipo do ID
                    .orElseThrow(() -> new EntityNotFoundException("Endereco não encontrada."));

            // Se não houver dependências, exclui a endereco
            enderecoRepository.delete(endereco);
            return ResponseEntity.ok("Endereco excluída com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}