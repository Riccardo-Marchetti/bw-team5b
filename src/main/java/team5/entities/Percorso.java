package team5.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "percorso")
public class Percorso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;

    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;

    @Column(name = "tempo_effettivo")
    private int tempoEffettivo;

    // Costruttore
    public Percorso() {}

    public Percorso(Mezzo mezzo, Tratta tratta, int tempoEffettivo) {
        this.mezzo = mezzo;
        this.tratta = tratta;
        this.tempoEffettivo = tempoEffettivo;
    }

    // Getter e setter
    public int getId() {
        return id;
    }



    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public int getTempoEffettivo() {
        return tempoEffettivo;
    }

    public void setTempoEffettivo(int tempoEffettivo) {
        this.tempoEffettivo = tempoEffettivo;
    }

    @Override
    public String toString() {
        return "Percorso{" +
                "id=" + id +
                ", mezzo=" + mezzo +
                ", tratta=" + tratta +
                ", tempoEffettivo=" + tempoEffettivo +
                '}';
    }
}



