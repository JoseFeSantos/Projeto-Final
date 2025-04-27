package projetoFinal.Projeto.Final.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "banco")
@Data
public class DadosBancarios {

    @Id
    @Column(name = "codigobanco", nullable = false, unique = true)
    private Long codigoBanco;

    @Column(name = "nomebanco", nullable = false, length = 100)
    private String nome;

    public DadosBancarios() {
    }

    public DadosBancarios(Long codigoBanco, String nome) {
        this.codigoBanco = codigoBanco;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return codigoBanco + " - " + nome;
    }
}