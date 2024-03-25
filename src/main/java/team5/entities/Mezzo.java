package team5.entities;

import jakarta.persistence.*;
import team5.enums.TipoMezzo;

@Entity
@Table(name = "mezzo")
public class Mezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoMezzo tipo;
    private int capienza;

    public Mezzo() {}

    public Mezzo(TipoMezzo tipo, int capienza) {
        this.tipo = tipo;
        this.capienza = capienza;
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

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    @Override
    public String toString() {
        return "Mezzo{" +
                "id=" + id +
                ", tipo=" + tipo +
                ", capienza=" + capienza +
                '}';
    }
}
