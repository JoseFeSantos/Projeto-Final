package projetoFinal.Projeto.Final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoFinal.Projeto.Final.model.CategoriaDespesa;
import projetoFinal.Projeto.Final.repository.CategoriaDespesaRepository;
import projetoFinal.Projeto.Final.service.CategoriaDespesaService;
import projetoFinal.Projeto.Final.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("categoriadespesa")
public class CategoriaDespesaController {

    public CategoriaDespesaController(CategoriaDespesaService categoriaDespesaService, CategoriaDespesaRepository categoriaDespesaRepository) {
        this.categoriaDespesaService = categoriaDespesaService;
        this.categoriaDespesaRepository = categoriaDespesaRepository;
    }

    @PostMapping
    public ResponseEntity<CategoriaDespesa> criarCategoriaDespesa(@RequestBody CategoriaDespesa categoriaDespesa) {
        CategoriaDespesa categoriaDespesaSalva = categoriaDespesaRepository.save(categoriaDespesa);
        return ResponseEntity.ok(categoriaDespesaSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCategoriaDespesaPorId(@PathVariable String id) {
        return categoriaDespesaService.buscarCategoriaDespesaPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCategoriaDespesa(@PathVariable String id, @RequestBody CategoriaDespesa categoriaDespesaAtualizada) {
        return categoriaDespesaService.atualizarCategoriaDespesa(id, categoriaDespesaAtualizada);
    }

    @Autowired
    private CategoriaDespesaRepository categoriaDespesaRepository;
    @GetMapping
    public List<CategoriaDespesa> buscarCategoriaDespesaPeloNome(String nome) {
        String nomeSemAcento = StringUtils.removerAcentos(nome).toLowerCase();

        List<CategoriaDespesa> resultado = categoriaDespesaRepository.findAll().stream()
                .filter(categoriaDespesa -> {
                    String nomeCategoriaDespesaSemAcento = StringUtils.removerAcentos(categoriaDespesa.getNome()).toLowerCase();
                    return nomeCategoriaDespesaSemAcento.contains(nomeSemAcento);
                })
                .collect(Collectors.toList());

        System.out.println("Resultado da busca: " + resultado);
        return resultado;
    }

    @Autowired
    private CategoriaDespesaService categoriaDespesaService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCategoriaDespesa(@PathVariable String id) { // Use Long diretamente
        return categoriaDespesaService.deletarCategoriaDespesa(id); // Retorne diretamente o resultado do serviço
    }
}