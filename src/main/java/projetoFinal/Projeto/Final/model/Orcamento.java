package projetoFinal.Projeto.Final.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orcamento")
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "orcamento_id")
    private List<Servico> servicos;

    @Column(name = "valortotal")
    private double valorTotal;


    @Enumerated(EnumType.STRING)
    @Column(name = "meiodepagamento")
    private MeioDePagamento meioDePagamento;

    @Column(name = "datalimite")
    private LocalDate dataLimite;

    @Column(name = "observacao", length = 2000)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "statusdepagamento")
    private StatusDePagamento statusDePagamento;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public MeioDePagamento getMeioDePagamento() {
        return meioDePagamento;
    }

    public void setMeioDePagamento(MeioDePagamento meioDePagamento) {
        this.meioDePagamento = meioDePagamento;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public StatusDePagamento getStatusDePagamento() {
        return statusDePagamento;
    }

    public void setStatusDePagamento(StatusDePagamento statusDePagamento) {
        this.statusDePagamento = statusDePagamento;
    }

    @Override
    public String toString() {
        return "Orcamento{" +
                "id=" + id +
                ", cidade=" + cidade +
                ", material=" + material +
                ", servicos=" + servicos +
                ", valorTotal=" + valorTotal +
                ", meioDePagamento=" + meioDePagamento +
                ", dataLimite=" + dataLimite +
                ", observacao='" + observacao + '\'' +
                ", pessoa=" + pessoa +
                ", statusDePagamento=" + statusDePagamento +
                '}';
    }
}
