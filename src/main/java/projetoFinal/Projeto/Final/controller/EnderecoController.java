package projetoFinal.Projeto.Final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoFinal.Projeto.Final.model.Endereco;
import projetoFinal.Projeto.Final.repository.EnderecoRepository;
import projetoFinal.Projeto.Final.service.EnderecoService;
import projetoFinal.Projeto.Final.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    public EnderecoController(EnderecoService enderecoService, EnderecoRepository enderecoRepository) {
        this.enderecoService = enderecoService;
        this.enderecoRepository = enderecoRepository;
    }

    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@RequestBody Endereco endereco) {
        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        return ResponseEntity.ok(enderecoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarEnderecoPorId(@PathVariable int id) {
        return enderecoService.buscarEnderecoPorId(String.valueOf(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarEndereco(@PathVariable String id, @RequestBody Endereco enderecoAtualizada) {
        return enderecoService.atualizarEndereco(id, enderecoAtualizada);
    }

    @Autowired
    private EnderecoRepository enderecoRepository;
    @GetMapping
    public List<Endereco> buscarEnderecoPeloNome(String rua) {
        String ruaSemAcento = StringUtils.removerAcentos(rua).toLowerCase();

        List<Endereco> resultado = enderecoRepository.findAll().stream()
                .filter(endereco -> {
                    String nomeEnderecoSemAcento = StringUtils.removerAcentos(endereco.getRua()).toLowerCase();
                    return nomeEnderecoSemAcento.contains(ruaSemAcento);
                })
                .collect(Collectors.toList());

        System.out.println("Resultado da busca: " + resultado);
        return resultado;
    }

    @Autowired
    private EnderecoService enderecoService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarEndereco(@PathVariable int id) {
        return enderecoService.deletarEndereco(String.valueOf(id));
    }
}