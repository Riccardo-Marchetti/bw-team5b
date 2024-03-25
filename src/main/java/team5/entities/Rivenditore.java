package team5.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Rivenditore extends Emittente{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private long numeroTelefono;

    // ONE TO MANY BIGLIETTO
    @OneToMany (mappedBy = "rivenditore")
    private List<Biglietto> biglietto = new ArrayList<>();

    // COSTRUTTORE
    public Rivenditore(String indirizzo, String nome, long numeroTelefono, List<Biglietto> biglietto) {
        super(indirizzo);
        this.nome = nome;
        this.numeroTelefono = numeroTelefono;
        this.biglietto = biglietto;
    }
    public Rivenditore(){

    }

    // GETTER E SETTER
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(long numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public List<Biglietto> getBiglietto() {
        return biglietto;
    }

    public void setBiglietto(List<Biglietto> biglietto) {
        this.biglietto = biglietto;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Rivenditore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numeroTelefono=" + numeroTelefono +
                ", biglietto=" + biglietto +
                '}';
    }
}

