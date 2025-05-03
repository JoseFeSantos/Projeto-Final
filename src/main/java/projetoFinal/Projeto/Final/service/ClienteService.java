package projetoFinal.Projeto.Final.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projetoFinal.Projeto.Final.model.Cliente;
import projetoFinal.Projeto.Final.repository.ClienteRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<?> buscarClientePorId(String id) {
        try {
            // Busca o cliente pelo ID
            Cliente cliente = clienteRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrada."));

            // Retorna o cliente encontrado com status 200 (OK)
            return ResponseEntity.ok(cliente);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se o cliente não for encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 500 (Internal Server Error) em caso de outros erros
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar o cliente: " + e.getMessage());
        }
    }

    public ResponseEntity<?> atualizarCliente(String id, Cliente clienteAtualizado) {
        try {
            // Verifica se o cliente existe
            Cliente clienteExistente = clienteRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrada."));

            clienteExistente.setNome(clienteAtualizado.getNome());
            clienteExistente.setSexo(clienteAtualizado.getSexo());
            clienteExistente.setCpf(clienteAtualizado.getCpf());
            clienteExistente.setEmail(clienteAtualizado.getEmail());
            clienteExistente.setTelefone(clienteAtualizado.getTelefone());
            clienteExistente.setDataDeNascimento(clienteAtualizado.getDataDeNascimento());
            clienteExistente.setCep(clienteAtualizado.getCep());
            clienteExistente.setLogradouro(clienteAtualizado.getLogradouro());
            clienteExistente.setBairro(clienteAtualizado.getBairro());
            clienteExistente.setCidade(clienteAtualizado.getCidade());
            Cliente clienteSalvo = clienteRepository.save(clienteExistente);

            Map<String, Object> resposta = new HashMap<>();
            resposta.put("cliente", clienteSalvo);

            // Retorna a resposta com status 200 (OK)
            return ResponseEntity.ok(resposta);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se o cliente não for encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 400 (Bad Request) em caso de outros erros
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao atualizar o cliente: " + e.getMessage());
        }
    }

    public ResponseEntity<String> deletarCliente(String id) { // Use String como tipo do ID
        try {
            // Verifica se o cliente existe
            Cliente cliente = clienteRepository.findById(id) // Use String como tipo do ID
                    .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado."));

            clienteRepository.delete(cliente);
            return ResponseEntity.ok("Cliente excluído com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}