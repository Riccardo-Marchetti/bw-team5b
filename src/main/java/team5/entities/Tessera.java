package team5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Embeddable
public class Tessera {
    private long id;
    private Utente utente;
    @JoinColumn(name = "data_emissione")
    private LocalDate dataEmissione;
    @JoinColumn(name = "data_scadenza")
    private LocalDate dataScadenza;


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
