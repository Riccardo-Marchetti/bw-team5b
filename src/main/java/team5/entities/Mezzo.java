package team5.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "mezzo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Mezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numeroMatricola;

    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;
    public Mezzo( int numeroMatricola, Tratta tratta){
        this.numeroMatricola=numeroMatricola;
        this.tratta=tratta;
    }
    public Mezzo() {}
    public int getId() {
        return id;
    }
    public int getNumeroMatricola() {
        return numeroMatricola;
    }
    public void setNumeroMatricola(int numeroMatricola) {
        this.numeroMatricola = numeroMatricola;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    @Override
    public String toString() {
        return "Mezzo{" +
                "id=" + id +
                ", numeroMatricola=" + numeroMatricola +
                ", tratta=" + tratta +
                '}';
    }
}
