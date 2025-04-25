package projetoFinal.Projeto.Final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoFinal.Projeto.Final.model.Cidade;
import projetoFinal.Projeto.Final.repository.CidadeRepository;
import projetoFinal.Projeto.Final.service.CidadeService;
import projetoFinal.Projeto.Final.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cidade")
public class CidadeController {

    public CidadeController(CidadeService cidadeService, CidadeService cidadeService1, CidadeRepository cidadeRepository) {
        this.cidadeService = cidadeService1;
        this.cidadeRepository = cidadeRepository;
    }

    @PostMapping
    public ResponseEntity<Cidade> criarCidade(@RequestBody Cidade cidade) {
    Cidade cidadeSalva = cidadeRepository.save(cidade);
    return ResponseEntity.ok(cidadeSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCidadePorId(@PathVariable String id) {
        return cidadeService.buscarCidadePorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCidade(@PathVariable String id, @RequestBody Cidade cidadeAtualizada) {
        return cidadeService.atualizarCidade(id, cidadeAtualizada);
    }

    @Autowired
    private CidadeRepository cidadeRepository;
    @GetMapping
    public List<Cidade> buscarCidadePeloNome(String nome) {
        String nomeSemAcento = StringUtils.removerAcentos(nome).toLowerCase();

        List<Cidade> resultado = cidadeRepository.findAll().stream()
                .filter(cidade -> {
                    String nomeCidadeSemAcento = StringUtils.removerAcentos(cidade.getNome()).toLowerCase();
                    return nomeCidadeSemAcento.contains(nomeSemAcento);
                })
                .collect(Collectors.toList());

        System.out.println("Resultado da busca: " + resultado);
        return resultado;
    }

    @Autowired
    private CidadeService cidadeService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCidade(@PathVariable String id) { // Use Long diretamente
        return cidadeService.deletarCidade(id); // Retorne diretamente o resultado do serviço
    }
}