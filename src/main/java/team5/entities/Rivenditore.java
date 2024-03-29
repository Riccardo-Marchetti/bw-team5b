package team5.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Rivenditore extends Emittente{
    private String nome;
    private long numeroTelefono;

    public Rivenditore(String indirizzo, String nome, long numeroTelefono) {
        super(indirizzo);
        this.nome = nome;
        this.numeroTelefono = numeroTelefono;
    }

    public Rivenditore(String nome, long numeroTelefono) {
        this.nome = nome;
        this.numeroTelefono = numeroTelefono;
    }

    public Rivenditore(){

    }


    // GETTER E SETTER
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


    // TO STRING
    @Override
    public String toString() {
        return "Rivenditore{" +
                ", nome='" + nome + '\'' +
                ", numeroTelefono=" + numeroTelefono +
//                ", biglietto=" + biglietto +
                '}';
    }
}

