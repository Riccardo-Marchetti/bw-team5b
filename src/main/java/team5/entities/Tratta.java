package team5.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tratta")
public class Tratta {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "partenza")
    private String partenza;
    @Column(name = "capolinea")
    private String capolinea;
    @Column(name = "tempo_medio")
    private int tempo_medio;
//    @OneToMany
//    private InServizio inservizio;

    public Tratta(String partenza, String capolinea, int tempo_medio) {
        this.partenza = partenza;
        this.capolinea = capolinea;
        this.tempo_medio = tempo_medio;
    }

    public int getId() {
        return id;
    }



    public String getPartenza() {
        return partenza;
    }

    public void setPartenza(String partenza) {
        this.partenza = partenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public int getTempo_medio() {
        return tempo_medio;
    }

    public void setTempo_medio(int tempo_medio) {
        this.tempo_medio = tempo_medio;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "id=" + id +
                ", partenza='" + partenza + '\'' +
                ", capolinea='" + capolinea + '\'' +
                ", tempo_medio=" + tempo_medio +
                '}';
    }
}
