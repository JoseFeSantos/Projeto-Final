//package projetoFinal.Projeto.Final.service;
//
//import jakarta.persistence.EntityNotFoundException;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import projetoFinal.Projeto.Final.enus.StatusOrcamento;
//import projetoFinal.Projeto.Final.model.Cliente;
//import projetoFinal.Projeto.Final.model.Orcamento;
//import projetoFinal.Projeto.Final.model.Servico;
//import projetoFinal.Projeto.Final.repository.ClienteRepository;
//import projetoFinal.Projeto.Final.repository.OrcamentoRepository;
//
//import java.time.LocalDate;
//import java.util.Map;
//@Service
//@RequiredArgsConstructor
//public class OrcamentoService {
//
//    private final OrcamentoRepository orcamentoRepository;
//    private final ClienteRepository clienteRepository;
//    private final ServicoRepository servicoRepository;
//
//    @Transactional
//    public Orcamento criarOrcamentoComItens(Long clienteId, Map<Long, Integer> servicosQuantidades) {
//        // Busca o cliente
//        Cliente cliente = clienteRepository.findById(String.valueOf(clienteId))
//                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
//
//        // Cria o orçamento
//        Orcamento orcamento = new Orcamento();
//        orcamento.setCliente(cliente);
//        orcamento.setStatus(StatusOrcamento.RASCUNHO);
//        orcamento.setDataValidade(LocalDate.now().plusDays(7)); // 7 dias de validade
//
//        // Adiciona os itens
//        servicosQuantidades.forEach((servicoId, quantidade) -> {
//            Servico servico = servicoRepository.findById(servicoId)
//                    .orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado"));
//            orcamento.adicionarItem(servico, quantidade);
//        });
//
//        System.out.println("Valor total calculado: " + orcamento.getValorTotal());
//
//        return orcamentoRepository.save(orcamento);
//    }
//}