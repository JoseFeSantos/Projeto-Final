package projetoFinal.Projeto.Final.dto;

import projetoFinal.Projeto.Final.model.Estado;

public class CidadeDTO {
    private int id;
    private String nome;
    private Estado estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
