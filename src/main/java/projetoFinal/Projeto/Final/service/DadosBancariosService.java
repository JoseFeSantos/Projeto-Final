//package projetoFinal.Projeto.Final.service;
//
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import projetoFinal.Projeto.Final.model.Cliente;
//import projetoFinal.Projeto.Final.model.DadosBancarios;
//import projetoFinal.Projeto.Final.repository.DadosBancariosRepository;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class DadosBancariosService {
//
//    @Autowired
//    private DadosBancariosRepository dadosBancariosRepository;
//
//    public DadosBancarios salvarDadosBancarios(DadosBancarios dadosBancarios) {
//        if (dadosBancarios.getId() != null && dadosBancariosRepository.existsById(dadosBancarios.getId())) {
//            throw new RuntimeException("Já existe um registro com o ID " + dadosBancarios.getId());
//        }
//        return dadosBancariosRepository.save(dadosBancarios);
//    }
//
//    public DadosBancarios atualizarDadosBancarios(long id, DadosBancarios dadosBancarios) {
//        dadosBancarios.setId((long) Integer.parseInt(String.valueOf(id))); // Garante que o ID seja o mesmo
//        return dadosBancariosRepository.save(dadosBancarios);
//    }
//
//    public ResponseEntity<?> atualizarDadosBancarios(long id, Cliente bancoAtualizado) {
//        try {
//            // Verifica se o banco existe
//            DadosBancarios bancoExistente = dadosBancariosRepository.findById(id)
//                    .orElseThrow(() -> new EntityNotFoundException("Banco não encontrada."));
//
////            bancoExistente.setId(bancoAtualizado.getId());
//            bancoExistente.setNome(bancoExistente.getNome());
//            DadosBancarios  bancoSalvo = dadosBancariosRepository.save(bancoExistente);
//
//            Map<String, Object> resposta = new HashMap<>();
//            resposta.put("banco", bancoSalvo);
//
//            // Retorna a resposta com status 200 (OK)
//            return ResponseEntity.ok(resposta);
//        } catch (EntityNotFoundException e) {
//            // Retorna status 404 (Not Found) se o cliente não for encontrada
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(e.getMessage());
//        } catch (Exception e) {
//            // Retorna status 400 (Bad Request) em caso de outros erros
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("Erro ao atualizar o banco: " + e.getMessage());
//        }
//    }
//
//    public ResponseEntity<?> buscarDadosBancariosPorId(long id) {
//        try {
//            // Busca a cidade pelo ID
//            DadosBancarios dadosBancarios = dadosBancariosRepository.findById(id)
//                    .orElseThrow(() -> new EntityNotFoundException("DadosBancarios não encontrado."));
//
//            // Retorna o dadosBancarios encontrado com status 200 (OK)
//            return ResponseEntity.ok(dadosBancarios);
//        } catch (EntityNotFoundException e) {
//            // Retorna status 404 (Not Found) se o dadosBancarios não for encontrado
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(e.getMessage());
//        } catch (Exception e) {
//            // Retorna status 500 (Internal Server Error) em caso de outros erros
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Erro ao buscar o dadosBancarios: " + e.getMessage());
//        }
//    }
//
//    public List<DadosBancarios> buscarDadosBancariosPorNome(String nome) {
//        return dadosBancariosRepository.findByNome(nome);
//    }
//
//    public ResponseEntity<String> deletarBanco(long id) {
//        try {
//            // Verifica se o banco existe
//            DadosBancarios dadosBancarios = dadosBancariosRepository.findById(id)
//                    .orElseThrow(() -> new EntityNotFoundException("Banco não encontrado."));
//
//            dadosBancariosRepository.delete(dadosBancarios);
//            return ResponseEntity.ok("Banco excluído com sucesso.");
//        } catch (EntityNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(e.getMessage());
//        }
//    }
//}