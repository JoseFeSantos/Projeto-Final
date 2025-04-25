/*
package projetoFinal.Projeto.Final.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoFinal.Projeto.Final.model.Cliente;
import projetoFinal.Projeto.Final.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) {
        // Verifica se já existe um cliente com o mesmo CPF
        if (clienteRepository.existsByCpf(cliente.getCpf())) {
            throw new RuntimeException("Já existe um cliente cadastrado com este CPF");
        }
        // Se não existir, salva o cliente
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarClientePorId(String id) {
        return clienteRepository.findById(id);
    }

    public void deletarCliente(String id) {
        clienteRepository.deleteById(id);
    }

    public Cliente atualizarCliente(String id, Cliente cliente) {
        cliente.setId(Integer.parseInt(id)); // Garante que o ID seja o mesmo
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarClientesPorNome(String nome) {
        return clienteRepository.findByNome(nome);
    }
}
*/
