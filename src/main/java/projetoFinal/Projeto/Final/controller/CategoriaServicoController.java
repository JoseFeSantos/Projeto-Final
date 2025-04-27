package projetoFinal.Projeto.Final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoFinal.Projeto.Final.model.CategoriaServico;
import projetoFinal.Projeto.Final.repository.CategoriaServicoRepository;
import projetoFinal.Projeto.Final.service.CategoriaServicoService;
import projetoFinal.Projeto.Final.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("categoriaservico")
public class CategoriaServicoController {

    public CategoriaServicoController(CategoriaServicoService categoriaServicoService, CategoriaServicoRepository categoriaServicoRepository) {
        this.categoriaServicoService = categoriaServicoService;
        this.categoriaServicoRepository = categoriaServicoRepository;
    }

    @PostMapping
    public ResponseEntity<CategoriaServico> criarCategoriaServico(@RequestBody CategoriaServico categoriaServico) {
        CategoriaServico categoriaServicoSalva = categoriaServicoRepository.save(categoriaServico);
        return ResponseEntity.ok(categoriaServicoSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCategoriaServicoPorId(@PathVariable String id) {
        return categoriaServicoService.buscarCategoriaServicoPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCategoriaServico(@PathVariable String id, @RequestBody CategoriaServico categoriaServicoAtualizada) {
        return categoriaServicoService.atualizarCategoriaServico(id, categoriaServicoAtualizada);
    }

    @Autowired
    private CategoriaServicoRepository categoriaServicoRepository;
    @GetMapping
    public List<CategoriaServico> buscarCategoriaServicoPeloNome(String nome) {
        String nomeSemAcento = StringUtils.removerAcentos(nome).toLowerCase();

        List<CategoriaServico> resultado = categoriaServicoRepository.findAll().stream()
                .filter(categoriaServico -> {
                    String nomeCategoriaServicoSemAcento = StringUtils.removerAcentos(categoriaServico.getNome()).toLowerCase();
                    return nomeCategoriaServicoSemAcento.contains(nomeSemAcento);
                })
                .collect(Collectors.toList());

        System.out.println("Resultado da busca: " + resultado);
        return resultado;
    }

    @Autowired
    private CategoriaServicoService categoriaServicoService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCategoriaServico(@PathVariable String id) { // Use Long diretamente
        return categoriaServicoService.deletarCategoriaServico(id); // Retorne diretamente o resultado do serviço
    }
}