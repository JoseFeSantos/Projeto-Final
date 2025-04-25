package projetoFinal.Projeto.Final.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoriaservico")
public class CategoriaServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "CategoriaServico{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
