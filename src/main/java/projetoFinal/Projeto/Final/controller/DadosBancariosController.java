package projetoFinal.Projeto.Final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoFinal.Projeto.Final.model.DadosBancarios;
import projetoFinal.Projeto.Final.repository.DadosBancariosRepository;
import projetoFinal.Projeto.Final.service.DadosBancariosService;
import projetoFinal.Projeto.Final.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("banco")
public class DadosBancariosController {

    public DadosBancariosController(DadosBancariosService dadosBancariosService, DadosBancariosRepository dadosBancariosRepository) {
        this.dadosBancariosService = dadosBancariosService;
        this.dadosBancariosRepository = dadosBancariosRepository;
    }

    @PostMapping
    public ResponseEntity<DadosBancarios> criarDadosBancarios(@RequestBody DadosBancarios dadosBancarios) {
        DadosBancarios dadosBancariosSalva = dadosBancariosRepository.save(dadosBancarios);
        return ResponseEntity.ok(dadosBancariosSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarDadosBancariosPorId(@PathVariable long id) {
        return dadosBancariosService.buscarDadosBancariosPorId(id);
    }

    @PutMapping("/{id}")
    public DadosBancarios atualizarDadosBancarios(@PathVariable long id, @RequestBody DadosBancarios dadosBancariosAtualizada) {
        return dadosBancariosService.atualizarDadosBancarios(id, dadosBancariosAtualizada);
    }

    @Autowired
    private DadosBancariosRepository dadosBancariosRepository;
    @GetMapping
    public List<DadosBancarios> buscarDadosBancariosPeloNome(String nome) {
        String nomeSemAcento = StringUtils.removerAcentos(nome).toLowerCase();

        List<DadosBancarios> resultado = dadosBancariosRepository.findAll().stream()
                .filter(dadosBancarios -> {
                    String nomeDadosBancariosSemAcento = StringUtils.removerAcentos(dadosBancarios.getNome()).toLowerCase();
                    return nomeDadosBancariosSemAcento.contains(nomeSemAcento);
                })
                .collect(Collectors.toList());

        System.out.println("Resultado da busca: " + resultado);
        return resultado;
    }

    @Autowired
    private DadosBancariosService dadosBancariosService;


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarDados(@PathVariable long id) {
        return dadosBancariosService.deletarBanco(id);
    }

}