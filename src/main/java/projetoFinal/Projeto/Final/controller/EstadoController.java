package projetoFinal.Projeto.Final.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoFinal.Projeto.Final.model.Estado;
import projetoFinal.Projeto.Final.repository.EstadoRepository;
import projetoFinal.Projeto.Final.service.EstadoService;
import projetoFinal.Projeto.Final.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("estado")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @PostMapping
    public ResponseEntity<Estado> salvar(@RequestBody Estado estado) {
        Estado estadoSalvo = estadoService.salvarEstado(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarEstadoPorId(@PathVariable String id) {
        return estadoService.buscarEstadoPorId(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Estado> atualizar(@PathVariable("id") String id, @RequestBody Estado estado) {
        Estado estadoAtualizado = estadoService.atualizarEstado(id, estado);
        return ResponseEntity.ok(estadoAtualizado);
    }

    @Autowired
    private EstadoRepository estadoRepository;
    @GetMapping
    public List<Estado> buscarEstadoPeloNome(String nome) {
        String nomeSemAcento = StringUtils.removerAcentos(nome).toLowerCase();

        List<Estado> resultado = estadoRepository.findAll().stream()
                .filter(estado -> {
                    String nomeEstadoSemAcento = StringUtils.removerAcentos(estado.getNome()).toLowerCase();
                    return nomeEstadoSemAcento.contains(nomeSemAcento);
                })
                .collect(Collectors.toList());

        System.out.println("Resultado da busca: " + resultado);
        return resultado;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarEstado(@PathVariable Long id) {
        try {
            String mensagem = estadoService.deletarEstado(id);
            return ResponseEntity.ok(mensagem);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
