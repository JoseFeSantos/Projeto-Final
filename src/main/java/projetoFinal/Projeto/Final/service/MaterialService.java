package projetoFinal.Projeto.Final.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projetoFinal.Projeto.Final.model.Material;
import projetoFinal.Projeto.Final.repository.MaterialRepository;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public Material salvarMaterial(Material material) {
        // Verifica se já existe um material com o mesmo nome
        if (materialRepository.existsByNome(material.getNome())) {
            throw new RuntimeException("Já existe um material cadastrado com este nome");
        }
        // Se não existir, salva o material
        return materialRepository.save(material);
    }

    public Material atualizarMaterial(long id, Material material) {
        material.setId((long) Integer.parseInt(String.valueOf(id))); // Garante que o ID seja o mesmo
        return materialRepository.save(material);
    }

    public ResponseEntity<?> buscarMaterialPorId(String id) {
        try {
            // Busca a cidade pelo ID
            Material material = materialRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Material não encontrado."));

            // Retorna o material encontrado com status 200 (OK)
            return ResponseEntity.ok(material);
        } catch (EntityNotFoundException e) {
            // Retorna status 404 (Not Found) se o material não for encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Retorna status 500 (Internal Server Error) em caso de outros erros
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar o material: " + e.getMessage());
        }
    }

    public List<Material> buscarMaterialPorNome(String nome) {
        return materialRepository.findByNome(nome);
    }

    public String deletarMaterial(Long id) {
        // Verifica se o material existe
        Material material = materialRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException("Material não encontrado."));

        // Se não houver dependências, exclui o material
        materialRepository.delete(material);
        return "Material excluído com sucesso.";
    }
}