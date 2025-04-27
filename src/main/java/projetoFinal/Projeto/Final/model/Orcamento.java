//package projetoFinal.Projeto.Final.model;
//
//import jakarta.persistence.*;
//import projetoFinal.Projeto.Final.enus.MeioDePagamento;
//import projetoFinal.Projeto.Final.enus.StatusOrcamento;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "orcamento")
//public class Orcamento {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "cliente_id", nullable = false)
//    private Cliente cliente;
//
//    @OneToMany(mappedBy = "orcamento", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ItemOrcamento> itens = new ArrayList<>();
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "meio_pagamento")
//    private MeioDePagamento meioDePagamento;
//
//    @Column(name = "data_validade")
//    private LocalDate dataValidade;
//
//    @Column(length = 500)
//    private String observacoes;
//
//    @Enumerated(EnumType.STRING)
//    private StatusOrcamento status;
//
//    // Método que calcula o valor total dinamicamente
//    @Transient
//    public Double getValorTotal() {
//        if (itens == null || itens.isEmpty()) {
//            return 0.0;
//        }
//        return itens.stream()
//                .mapToDouble(item -> item.getServico().getValor() * item.getQuantidade())
//                .sum();
//    }
//
//    // Método conveniente para adicionar itens
//    public void adicionarItem(Servico servico, int quantidade) {
//        ItemOrcamento item = new ItemOrcamento();
//        item.setServico(servico);
//        item.setQuantidade(quantidade);
//        item.setOrcamento(this);
//        itens.add(item);
//    }
//
//    // Getters e Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//
//    public List<ItemOrcamento> getItens() {
//        return itens;
//    }
//
//    public void setItens(List<ItemOrcamento> itens) {
//        this.itens = itens;
//    }
//
//    public MeioDePagamento getMeioDePagamento() {
//        return meioDePagamento;
//    }
//
//    public void setMeioDePagamento(MeioDePagamento meioDePagamento) {
//        this.meioDePagamento = meioDePagamento;
//    }
//
//    public LocalDate getDataValidade() {
//        return dataValidade;
//    }
//
//    public void setDataValidade(LocalDate dataValidade) {
//        this.dataValidade = dataValidade;
//    }
//
//    public String getObservacoes() {
//        return observacoes;
//    }
//
//    public void setObservacoes(String observacoes) {
//        this.observacoes = observacoes;
//    }
//
//    public StatusOrcamento getStatus() {
//        return status;
//    }
//
//    public void setStatus(StatusOrcamento status) {
//        this.status = status;
//    }
//}