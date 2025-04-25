/*
package projetoFinal.Projeto.Final.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoFinal.Projeto.Final.model.Colaborador;
import projetoFinal.Projeto.Final.service.ColaboradorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("colaborador")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @PostMapping
    public ResponseEntity<Colaborador> salvar(@RequestBody Colaborador colaborador) {
        Colaborador colaboradorSalvo = colaboradorService.salvarColaborador(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> obterColaborador(@PathVariable("id") String id) {
        Optional<Colaborador> colaborador = colaboradorService.buscarColaboradorPorId(id);
        return colaborador.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletar(@PathVariable String id) {
        try {
            colaboradorService.deletarColaborador(id);
            return ResponseEntity.ok("Colaborador deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado");
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Colaborador> atualizarColaborador(@PathVariable("id") String id, @RequestBody Colaborador colaborador) {
        Colaborador colaboradorAtualizado = colaboradorService.atualizarColaborador(id, colaborador);
        return ResponseEntity.ok(colaboradorAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<Colaborador>> buscar(@RequestParam("nome") String nome) {
        List<Colaborador> colaborador = colaboradorService.buscarColaboradorPorNome(nome);
        return ResponseEntity.ok(colaborador);
    }
}*/
