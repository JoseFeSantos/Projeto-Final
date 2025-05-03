package projetoFinal.Projeto.Final.dtos;

import org.antlr.v4.runtime.misc.NotNull;

public class EstadoDTO {
    @NotNull
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}