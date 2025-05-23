package projetoFinal.Projeto.Final.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projetoFinal.Projeto.Final.model.Estado;
import projetoFinal.Projeto.Final.repository.CidadeRepository;
import projetoFinal.Projeto.Final.repository.EstadoRepository;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvarEstado(Estado estado) {
        // Verifica se já existe um estado com o mesmo nome
        if (estadoRepository.existsByNome(estado.getNome())) {
            throw new RuntimeException("Já existe um estado cadastrado com este nome");
        }
        // Se não existir, salva o estado
        return estadoRepository.save(estado);
    }

    @Autowired
    private CidadeRepository cidadeRepository;

    public Estado atualizarEstado(String id, Estado estado) {
        estado.setId(Integer.parseInt(id)); // Garante que o ID seja o mesmo
        return estadoRepository.save(estado);
    }

    public ResponseEntity<?> buscarEstadoPorId(String id) {
        try {
            // Busca a cidade pelo ID
            Estado estado = estadoRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado."));

            // Retorna o estado encontrado com status 200 (OK)
            return ResponseEntity.ok(estado);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se o estado não for encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 500 (Internal Server Error) em caso de outros erros
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar o estado: " + e.getMessage());
        }
    }

    public List<Estado> buscarEstadoPorNome(String nome) {
        return estadoRepository.findByNome(nome);
    }

    public String deletarEstado(Long id) {
        // Verifica se o estado existe
        Estado estado = estadoRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado."));


        // Se não houver dependências, exclui o estado
        estadoRepository.delete(estado);
        return "Estado excluído com sucesso.";
    }
}