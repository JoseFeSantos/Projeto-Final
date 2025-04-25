package projetoFinal.Projeto.Final.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("COLABORADOR")
public class Colaborador extends Pessoa {

}