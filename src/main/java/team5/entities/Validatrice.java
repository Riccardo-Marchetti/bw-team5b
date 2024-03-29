package team5.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "validatrice")
public class Validatrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    private Mezzo mezzo;

    @ManyToOne
    @JoinColumn(name = "id_biglietto")
    private Biglietto biglietto;


    public Validatrice() {}

    public Validatrice(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public Long getId() {
        return id;
    }


    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public Biglietto getBiglietto() {
        return biglietto;
    }

    public void setBiglietto(Biglietto biglietto) {
        this.biglietto = biglietto;
    }
}

