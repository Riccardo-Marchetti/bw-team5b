package team5.entities;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "findUtenteById", query = "SELECT u FROM Utente u WHERE u.id = :utenteId")
@NamedQuery(name = "deleteUtente", query = "DELETE FROM Utente u WHERE u.id = :utenteId")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cognome;
    @OneToOne (mappedBy = "utente")
    private Tessera tessera;
// CONSTRUCTORS

    public Utente() {
    }

    public Utente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }


// GETTERS & SETTERS
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }
    // TO STRING

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
//                ", tessera=" + tessera +
                '}';
    }
}
