package projetoFinal.Projeto.Final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoFinal.Projeto.Final.model.Servico;
import projetoFinal.Projeto.Final.repository.ServicoRepository;
import projetoFinal.Projeto.Final.service.ServicoService;
import projetoFinal.Projeto.Final.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("servico")
public class ServicoController {

    public ServicoController(ServicoService servicoService, ServicoRepository servicoRepository) {
        this.servicoService = this.servicoService;
        this.servicoRepository = servicoRepository;
    }

    @PostMapping
    public ResponseEntity<Servico> criarServico(@RequestBody Servico servico) {
        Servico servicoSalva = servicoRepository.save(servico);
        return ResponseEntity.ok(servicoSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarServicoPorId(@PathVariable String id) {
        return servicoService.buscarServicoPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarServico(@PathVariable String id, @RequestBody Servico servicoAtualizada) {
        return servicoService.atualizarServico(id, servicoAtualizada);
    }

    @Autowired
    private ServicoRepository servicoRepository;
    @GetMapping
    public List<Servico> buscarServicoPeloNome(String nome) {
        String nomeSemAcento = StringUtils.removerAcentos(nome).toLowerCase();

        List<Servico> resultado = servicoRepository.findAll().stream()
                .filter(servico -> {
                    String nomeServicoSemAcento = StringUtils.removerAcentos(servico.getNome()).toLowerCase();
                    return nomeServicoSemAcento.contains(nomeSemAcento);
                })
                .collect(Collectors.toList());

        System.out.println("Resultado da busca: " + resultado);
        return resultado;
    }

    @Autowired
    private ServicoService servicoService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarServico(@PathVariable String id) { // Use Long diretamente
        return servicoService.deletarServico(id); // Retorne diretamente o resultado do serviço
    }
}