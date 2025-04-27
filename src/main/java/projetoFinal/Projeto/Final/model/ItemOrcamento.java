//package projetoFinal.Projeto.Final.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "item_orcamento")
//public class ItemOrcamento {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "orcamento_id", nullable = false)
//    private Orcamento orcamento;
//
//    @ManyToOne
//    @JoinColumn(name = "servico_id", nullable = false)
//    private Servico servico;
//
//    @Column(nullable = false)
//    private Integer quantidade = 1;
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
//    public Orcamento getOrcamento() {
//        return orcamento;
//    }
//
//    public void setOrcamento(Orcamento orcamento) {
//        this.orcamento = orcamento;
//    }
//
//    public Servico getServico() {
//        return servico;
//    }
//
//    public void setServico(Servico servico) {
//        this.servico = servico;
//    }
//
//    public Integer getQuantidade() {
//        return quantidade;
//    }
//
//    public void setQuantidade(Integer quantidade) {
//        this.quantidade = quantidade;
//    }
//}