package team5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="manutenzione")
public class Manutenzione {
    @Id
    @GeneratedValue
    private int id;

    private LocalDate data_inizio;

    private LocalDate data_fine;
    @Column(name = "tipo_manutenzione")
    private String tipo_manutenzione;
    @ManyToOne
    @JoinColumn(name = "mezzo_id", referencedColumnName = "id")
    private Mezzo mezzo;
    public Manutenzione(LocalDate data_inizio, LocalDate data_fine, String tipo_manutenzione, Mezzo mezzo) {
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.tipo_manutenzione = tipo_manutenzione;
        this.mezzo = mezzo;
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
        return "Manutenzione{" +
                "id=" + id +
                ", data_inizio=" + data_inizio +
                ", data_fine=" + data_fine +
                ", tipo_manutenzione='" + tipo_manutenzione + '\'' +
                '}';
    }
}
