package team5.entities;

import jakarta.persistence.*;
import team5.enums.TipoAbbonamento;
import java.time.LocalDate;

@Entity
@Table(name = "abbonamento")
public class Abbonamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Utente utente;
    @JoinColumn(name = "data_emissione")
    private LocalDate dataEmissione;
    @JoinColumn(name = "data_scadenza")
    private LocalDate dataScadenza;
    @Enumerated(EnumType.STRING)
    private TipoAbbonamento tipo;
    @ManyToOne
    private Emittente emittente;

    public Abbonamento(Utente utente, LocalDate dataEmissione,  TipoAbbonamento tipo, Emittente emittente) {
        this.utente = utente;
        this.dataEmissione = dataEmissione;
        this.tipo = tipo;
        this.dataScadenza = calcolaScadenza();
        this.emittente = emittente;
    }

    public Abbonamento() {
    }

    // Getter e Setter

    public long getId() {
        return id;
    }


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

    public TipoAbbonamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoAbbonamento tipo) {
        this.tipo = tipo;
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
        return "Abbonamento{" +
                "id=" + id +
                ", utente=" + utente +
                ", dataEmissione=" + dataEmissione +
                ", dataScadenza=" + dataScadenza +
                ", tipo=" + tipo +
                ", emittente=" + emittente +
                '}';
    }
    // METODI
    private LocalDate calcolaScadenza(){
        if (tipo == TipoAbbonamento.SETTIMANALE){
           this.dataScadenza = dataEmissione.plusDays(7);
        } else if (tipo == TipoAbbonamento.MENSILE){
            this.dataScadenza = dataEmissione.plusMonths(1);
        }
        return dataScadenza;
    }
}
