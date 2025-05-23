package projetoFinal.Projeto.Final.model;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "rua", nullable = false)
    private String rua;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "distrito", nullable = true)
    private String distrito;

    @Column(name = "complemento", nullable = true)
    private String complemento;

    @Column(name = "cidade", nullable = false)
    private String Cidade;

    @Column(name = "estado", nullable = false)
    private String Estado;

    public Endereco(){}

    public Endereco(int id, Cliente cliente, String cep, String rua, String numero, String distrito, String complemento, String cidade, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.distrito = distrito;
        this.complemento = complemento;
        Cidade = cidade;
        Estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}

