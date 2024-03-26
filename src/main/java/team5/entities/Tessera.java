package team5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Tessera {
    private long id;
    @Column(name = "data_emissione")
    private LocalDate dataEmissione;
    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;
    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;


// CONSTRUCTORS

    public Tessera() {
    }

    public Tessera(Utente utente, LocalDate dataEmissione, LocalDate dataScadenza) {
        this.utente = utente;
        this.dataEmissione = dataEmissione;
        this.dataScadenza = dataScadenza;
    }

// GETTERS & SETTERS

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

// TO STRING
    @Override
    public String toString() {
        return "Tessera{" +
                ", utente=" + utente +
                ", dataEmissione=" + dataEmissione +
                ", dataScadenza=" + dataScadenza +
                '}';
    }
}
