package projetoFinal.Projeto.Final.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "banco")
@Data
public class DadosBancarios {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    public DadosBancarios() {
    }

    public DadosBancarios(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return id + " - " + nome;
    }
}