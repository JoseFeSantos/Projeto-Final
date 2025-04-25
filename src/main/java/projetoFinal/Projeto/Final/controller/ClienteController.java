/*
package projetoFinal.Projeto.Final.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoFinal.Projeto.Final.model.Cliente;
import projetoFinal.Projeto.Final.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteService.salvarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obterCliente(@PathVariable("id") String id) {
        Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
        return cliente.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletar(@PathVariable String id) {
        try {
            clienteService.deletarCliente(id);
            return ResponseEntity.ok("Cliente deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable("id") String id, @RequestBody Cliente cliente) {
        Cliente clienteAtualizado = clienteService.atualizarCliente(id, cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscar(@RequestParam("nome") String nome) {
        List<Cliente> clientes = clienteService.buscarClientesPorNome(nome);
        return ResponseEntity.ok(clientes);
    }
}*/
