package team5.entities;

import jakarta.persistence.*;
import team5.enums.StatoDeiMezzi;

@Entity
public class StatoMezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private StatoDeiMezzi stato;

    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    private Mezzo mezzo;

    public StatoMezzo() {}

    public StatoMezzo(StatoDeiMezzi stato, Mezzo mezzo) {
        this.stato = stato;
        this.mezzo = mezzo;
    }

    public StatoDeiMezzi getStato() {
        return stato;
    }

    public void setStato(StatoDeiMezzi stato) {
        this.stato = stato;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    @Override
    public String toString() {
        return "StatoMezzo{" +
                "stato=" + stato +
                ", mezzo=" + mezzo +
                '}';
    }
}
