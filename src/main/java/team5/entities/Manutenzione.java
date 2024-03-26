package team5.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="manutenzione")
public class Manutenzione {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "data_inizio")
    private Date data_inizio;
    @Column(name = "data_fine")
    private Date data_fine;
    @Column(name = "tipo_manutenzione")
    private String tipo_manutenzione;
    @OneToMany(mappedBy = "manutenzione")
    private List<Autobus> autobus;
    @OneToMany(mappedBy = "manutenzione")
    private List<Tram> tram;
    public Manutenzione(Date data_inizio, Date data_fine, String tipo_manutenzione) {
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.tipo_manutenzione = tipo_manutenzione;
    }
    public Manutenzione() {
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
    public String getTipo_manutenzione() {
        return tipo_manutenzione;
    }
    public void setTipo_manutenzione(String tipo_manutenzione) {
        this.tipo_manutenzione = tipo_manutenzione;
    }
}
