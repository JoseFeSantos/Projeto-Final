package projetoFinal.Projeto.Final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoFinal.Projeto.Final.model.Pessoa;
import projetoFinal.Projeto.Final.repository.PessoaRepository;
import projetoFinal.Projeto.Final.service.PessoaService;
import projetoFinal.Projeto.Final.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa colaborador) {
        Pessoa colaboradorSalvo = pessoaService.salvarPessoa(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPessoaPorId(@PathVariable String id) {
        return pessoaService.buscarPessoaPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPessoa(@PathVariable String id) { // Use Long diretamente
        return pessoaService.deletarPessoa(id); // Retorne diretamente o resultado do serviço
    }

    @PutMapping("{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable("id") String id, @RequestBody Pessoa pessoa) {
        Pessoa pessoaAtualizada = pessoaService.atualizarPessoa(id, pessoa);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    @Autowired
    private PessoaRepository pessoaRepository;
    @GetMapping
    public List<Pessoa> buscarPessoaPeloNome(String nome) {
        String nomeSemAcento = StringUtils.removerAcentos(nome).toLowerCase();

        List<Pessoa> resultado = pessoaRepository.findAll().stream()
                .filter(pessoa -> {
                    String nomePessoaSemAcento = StringUtils.removerAcentos(pessoa.getNome()).toLowerCase();
                    return nomePessoaSemAcento.contains(nomeSemAcento);
                })
                .collect(Collectors.toList());

        System.out.println("Resultado da busca: " + resultado);
        return resultado;
    }

}
