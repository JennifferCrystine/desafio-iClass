package br.com.iclass.mvc.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
public class Aventura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "personagem_id")
    private Personagem personagem;

    @NotNull
    private int xp = 0;

    @NotNull
    private Date data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }


    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Aventura() {

    }

    public Aventura(int id, Personagem personagem, int xp, Date data) {
        this.id = id;
        this.personagem = personagem;
        this.xp = xp;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Aventura{" +
                "personagem=" + personagem +
                ", xp=" + xp +
                ", data=" + data +
                '}';
    }
}
