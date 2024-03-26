package team5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team5.dao.BigliettoDAO;
import team5.dao.RivenditoreDAO;
import team5.entities.Biglietto;
import team5.entities.Rivenditore;
import team5.entities.Tessera;
import team5.entities.Utente;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionetrasporti");
    public static void main(String[] args) {
        System.out.println("ciao");


    }
}
