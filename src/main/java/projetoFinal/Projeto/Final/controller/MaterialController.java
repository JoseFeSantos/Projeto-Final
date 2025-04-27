package projetoFinal.Projeto.Final.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoFinal.Projeto.Final.model.Material;
import projetoFinal.Projeto.Final.repository.MaterialRepository;
import projetoFinal.Projeto.Final.service.MaterialService;
import projetoFinal.Projeto.Final.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("material")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @PostMapping
    public ResponseEntity<Material> salvar(@RequestBody Material material) {
        Material materialSalvo = materialService.salvarMaterial(material);
        return ResponseEntity.status(HttpStatus.CREATED).body(materialSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarMaterialPorId(@PathVariable String id) {
        return materialService.buscarMaterialPorId(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Material> atualizar(@PathVariable("id") long id, @RequestBody Material material) {
        Material materialAtualizado = materialService.atualizarMaterial(id, material);
        return ResponseEntity.ok(materialAtualizado);
    }

    @Autowired
    private MaterialRepository materialRepository;
    @GetMapping
    public List<Material> buscarMaterialPeloNome(String nome) {
        String nomeSemAcento = StringUtils.removerAcentos(nome).toLowerCase();

        List<Material> resultado = materialRepository.findAll().stream()
                .filter(material -> {
                    String nomeMaterialSemAcento = StringUtils.removerAcentos(material.getNome()).toLowerCase();
                    return nomeMaterialSemAcento.contains(nomeSemAcento);
                })
                .collect(Collectors.toList());

        System.out.println("Resultado da busca: " + resultado);
        return resultado;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarMaterial(@PathVariable Long id) {
        try {
            String mensagem = materialService.deletarMaterial(id);
            return ResponseEntity.ok(mensagem);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
