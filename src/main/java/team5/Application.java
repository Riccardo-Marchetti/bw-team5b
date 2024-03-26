package team5;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team5.dao.BigliettoDAO;
import team5.dao.RivenditoreDAO;
import team5.entities.Biglietto;
import team5.entities.Rivenditore;
import team5.dao.TesseraDAO;
import team5.dao.UtenteDAO;
import team5.entities.Tessera;
import team5.entities.Utente;

import java.time.LocalDate;
import java.util.Locale;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionetrasporti");
    public static void main(String[] args) {
        System.out.println("ciao");


        EntityManager em = emf.createEntityManager();
        UtenteDAO utenteDAO = new UtenteDAO(em);
        TesseraDAO tesseraDAO = new TesseraDAO(em);


    /*    Supplier<Utente> utenteSupplier = ()->{
            Faker faker = new Faker(Locale.ITALY);
            return new Utente(faker.rickAndMorty().character(), )

        };
*/


    }
}
