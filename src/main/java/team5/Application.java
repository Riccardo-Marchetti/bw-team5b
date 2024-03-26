package team5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team5.dao.BigliettoDAO;
import team5.entities.Biglietto;
import team5.entities.Rivenditore;
import team5.entities.Tessera;
import team5.entities.Utente;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionetrasporti");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        BigliettoDAO bd = new BigliettoDAO(em);
//        Rivenditore rd = new Rivenditore(em);
        Rivenditore rivenditore1 = new Rivenditore("via sder", "Matteo", 434242425);

//        Biglietto biglietto = new Biglietto(LocalDate.of(2024, 03, 27), "Milano", false, null, rivenditore1);
//        bd.salvaBiglietto(biglietto);
        System.out.println("ciao");


    }
}
