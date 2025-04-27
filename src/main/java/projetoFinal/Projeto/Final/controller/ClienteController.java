package projetoFinal.Projeto.Final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoFinal.Projeto.Final.model.Cliente;
import projetoFinal.Projeto.Final.repository.ClienteRepository;
import projetoFinal.Projeto.Final.service.ClienteService;
import projetoFinal.Projeto.Final.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    public ClienteController(ClienteService clienteService, ClienteRepository clienteRepository) {
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalva = clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable String id) {
        return clienteService.buscarClientePorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable String id, @RequestBody Cliente clienteAtualizada) {
        return clienteService.atualizarCliente(id, clienteAtualizada);
    }

    @Autowired
    private ClienteRepository clienteRepository;
    @GetMapping
    public List<Cliente> buscarClientePeloNome(String nome) {
        String nomeSemAcento = StringUtils.removerAcentos(nome).toLowerCase();

        List<Cliente> resultado = clienteRepository.findAll().stream()
                .filter(cliente -> {
                    String nomeClienteSemAcento = StringUtils.removerAcentos(cliente.getNome()).toLowerCase();
                    return nomeClienteSemAcento.contains(nomeSemAcento);
                })
                .collect(Collectors.toList());

        System.out.println("Resultado da busca: " + resultado);
        return resultado;
    }

    @Autowired
    private ClienteService clienteService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable String id) { // Use Long diretamente
        return clienteService.deletarCliente(id); // Retorne diretamente o resultado do serviço
    }
}