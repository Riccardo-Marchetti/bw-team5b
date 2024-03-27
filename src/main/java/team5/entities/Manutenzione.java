package team5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="manutenzione")
public class Manutenzione {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "data_inizio")
    private LocalDate data_inizio;
    @Column(name = "data_fine")
    private LocalDate data_fine;
    @Column(name = "tipo_manutenzione")
    private String tipo_manutenzione;
    @OneToMany(mappedBy = "manutenzione")
    private List<Autobus> autobus;
    @OneToMany(mappedBy = "manutenzione")
    private List<Tram> tram;
    public Manutenzione(LocalDate data_inizio, LocalDate data_fine, String tipo_manutenzione) {
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.tipo_manutenzione = tipo_manutenzione;
    }
    public Manutenzione() {
    }



    public int getId() {
        return id;
    }
    public LocalDate getData_inizio() {
        return data_inizio;
    }
    public void setData_inizio(LocalDate data_inizio) {
        this.data_inizio = data_inizio;
    }
    public LocalDate getData_fine() {
        return data_fine;
    }
    public void setData_fine(LocalDate data_fine) {
        this.data_fine = data_fine;
    }
    public String getTipo_manutenzione() {
        return tipo_manutenzione;
    }
    public void setTipo_manutenzione(String tipo_manutenzione) {
        this.tipo_manutenzione = tipo_manutenzione;
    }

    @Override
    public String toString() {
        return " " + id + " ";
    }
}
