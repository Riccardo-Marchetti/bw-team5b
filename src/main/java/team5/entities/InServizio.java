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
    @Column(name="tempo_effettivo")
    private int tempo_effettivo;
    @OneToMany(mappedBy = "inServizio")
    private List<Autobus> autobus;
    @OneToMany(mappedBy = "inServizio")
    private List<Tram> tram;
    @OneToMany(mappedBy = "inServizio")
    private List<Tratta> tratta;
    public InServizio(Date data_inizio, Date data_fine, int tempo_effettivo, List<Tratta> tratta) {
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.tempo_effettivo = tempo_effettivo;
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
    public int getTempo_effettivo() {
        return tempo_effettivo;
    }
    public void setTempo_effettivo(int tempo_effettivo) {
        this.tempo_effettivo = tempo_effettivo;
    }
    public List<Tratta> getTratta() {
        return tratta;
    }
    public void setTratta(List<Tratta> tratta) {
        this.tratta = tratta;
    }
}
