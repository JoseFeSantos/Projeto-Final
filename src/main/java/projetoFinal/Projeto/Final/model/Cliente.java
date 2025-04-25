package projetoFinal.Projeto.Final.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CLIENTE")
public class Cliente extends Pessoa {

}