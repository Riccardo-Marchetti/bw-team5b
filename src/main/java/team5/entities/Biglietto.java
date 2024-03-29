package team5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Biglietto {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private LocalDate dataEmissione;
//    private String puntoEmissione;
    private boolean vidimato;
    private LocalDate dataVidimazione;

    @ManyToOne
    @JoinColumn (name = "emittente_id")
    private Emittente emittente;
    // COSTRUTTORE

    public Biglietto(LocalDate dataEmissione, boolean vidimato, LocalDate dataVidimazione, Emittente emittente) {
        this.dataEmissione = dataEmissione;
        this.vidimato = vidimato;
        this.dataVidimazione = dataVidimazione;
        this.emittente = emittente;
    }

    public Biglietto(){

    }

    // GETTER E SETTER
    public long getId() {
        return id;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public boolean getVidimato() {
        return vidimato;
    }

    public void setVidimato(boolean vidimato) {
        this.vidimato = vidimato;
    }

    public LocalDate getDataVidimazione() {
        return dataVidimazione;
    }

    public void setDataVidimazione(LocalDate dataVidimazione) {
        this.dataVidimazione = dataVidimazione;
    }

    public Emittente getEmittente() {
        return emittente;
    }

    public void setEmittente(Emittente emittente) {
        this.emittente = emittente;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Biglietto{" +
                "id=" + id +
                ", dataEmissione=" + dataEmissione +
                ", vidimato=" + vidimato +
                ", dataVidimazione=" + dataVidimazione +
                ", emittente=" + emittente +
                '}';
    }
}
