package team5.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tratta")
public class Tratta {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "partenza")
    private String partenza;
    @Column(name = "capolinea")
    private String capolinea;
    @Column(name = "tempo_medio")
    private int tempo_medio;
    @Column(name = "numero_percorsi")
    private  int numeroPercorsi;
    @Column(name = "tempo_effettivo_percorsi")
    private int tempoEffettivoPercorso;
    @ManyToOne
    @JoinColumn(name = "inServizio_id")
    private InServizio inServizio;
    public Tratta(String partenza, String capolinea, int tempo_medio, InServizio inServizio) {
        this.partenza = partenza;
        this.capolinea = capolinea;
        this.tempo_medio = tempo_medio;
        this.inServizio = inServizio;
    }
    public Tratta() {
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
    public int getNumeroPercorsi() {
        return numeroPercorsi;
    }
    public void setNumeroPercorsi(int numeroPercorsi) {
        this.numeroPercorsi = numeroPercorsi;
    }
    public int getTempoEffettivoPercorso() {
        return tempoEffettivoPercorso;
    }
    public void setTempoEffettivoPercorso(int tempoEffettivoPercorso) {
        this.tempoEffettivoPercorso = tempoEffettivoPercorso;
    }
    public InServizio getInServizio() {
        return inServizio;
    }
    public void setInServizio(InServizio inServizio) {
        this.inServizio = inServizio;
    }
}
