package projetoFinal.Projeto.Final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoFinal.Projeto.Final.model.Colaborador;
import projetoFinal.Projeto.Final.repository.ColaboradorRepository;
import projetoFinal.Projeto.Final.service.ColaboradorService;
import projetoFinal.Projeto.Final.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("colaborador")
public class ColaboradorController {

    public ColaboradorController(ColaboradorService colaboradorService, ColaboradorRepository colaboradorRepository) {
        this.colaboradorService = colaboradorService;
        this.colaboradorRepository = colaboradorRepository;
    }

    @PostMapping
    public ResponseEntity<Colaborador> criarColaborador(@RequestBody Colaborador colaborador) {
        Colaborador colaboradorSalva = colaboradorRepository.save(colaborador);
        return ResponseEntity.ok(colaboradorSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarColaboradorPorId(@PathVariable String id) {
        return colaboradorService.buscarColaboradorPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarColaborador(@PathVariable String id, @RequestBody Colaborador colaboradorAtualizada) {
        return colaboradorService.atualizarColaborador(id, colaboradorAtualizada);
    }

    @Autowired
    private ColaboradorRepository colaboradorRepository;
    @GetMapping
    public List<Colaborador> buscarColaboradorPeloNome(String nome) {
        String nomeSemAcento = StringUtils.removerAcentos(nome).toLowerCase();

        List<Colaborador> resultado = colaboradorRepository.findAll().stream()
                .filter(colaborador -> {
                    String nomeColaboradorSemAcento = StringUtils.removerAcentos(colaborador.getNome()).toLowerCase();
                    return nomeColaboradorSemAcento.contains(nomeSemAcento);
                })
                .collect(Collectors.toList());

        System.out.println("Resultado da busca: " + resultado);
        return resultado;
    }

    @Autowired
    private ColaboradorService colaboradorService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarColaborador(@PathVariable String id) { // Use Long diretamente
        return colaboradorService.deletarColaborador(id); // Retorne diretamente o resultado do serviço
    }
}