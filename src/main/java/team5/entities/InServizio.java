package team5.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inServizio")
public class InServizio {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "data_inizio")
    private Date data_inizio;
    @Column(name = "data_fine")
    private Date data_fine;
    @Column(name="tempo_effettivo_tratta")
    private int tempo_effettivo_tratta;
    @OneToMany(mappedBy = "inServizio")
    private List<Tratta> tratta;

    //Relazione con lo stato

    public InServizio(Date data_inizio, Date data_fine, int tempo_effettivo_tratta, List<Tratta> tratta) {
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.tempo_effettivo_tratta = tempo_effettivo_tratta;
        this.tratta = tratta;
    }

    public InServizio() {

    }

    public int getId() {
        return id;
    }

    public Date getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(Date data_inizio) {
        this.data_inizio = data_inizio;
    }

    public Date getData_fine() {
        return data_fine;
    }

    public void setData_fine(Date data_fine) {
        this.data_fine = data_fine;
    }

    public int getTempo_effettivo_tratta() {
        return tempo_effettivo_tratta;
    }

    public void setTempo_effettivo_tratta(int tempo_effettivo_tratta) {
        this.tempo_effettivo_tratta = tempo_effettivo_tratta;
    }

    public List<Tratta> getTratta() {
        return tratta;
    }

    public void setTratta(List<Tratta> tratta) {
        this.tratta = tratta;
    }
}
