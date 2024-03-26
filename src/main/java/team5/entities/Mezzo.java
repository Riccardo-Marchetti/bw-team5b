package team5.entities;

import jakarta.persistence.*;
import team5.enums.StatoDeiMezzi;
import team5.enums.TipoMezzo;

@Entity
@Table(name = "mezzo")
public class Mezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoMezzo tipo;
    @Enumerated(EnumType.STRING)
    private StatoDeiMezzi stato;
    private int capienza;

    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;

    public Mezzo() {}

    public Mezzo(TipoMezzo tipo, StatoDeiMezzi stato, int capienza, Tratta tratta) {
        this.tipo = tipo;
        this.stato = stato;
        this.capienza = capienza;
        this.tratta = tratta;
    }

    public Long getId() {
        return id;
    }


    public TipoMezzo getTipo() {
        return tipo;
    }

    public void setTipo(TipoMezzo tipo) {
        this.tipo = tipo;
    }

    public StatoDeiMezzi getStato() {
        return stato;
    }

    public void setStato(StatoDeiMezzi stato) {
        this.stato = stato;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
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
                ", tipo=" + tipo +
                ", stato=" + stato +
                ", capienza=" + capienza +
                '}';
    }
}
