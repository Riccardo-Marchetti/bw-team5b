package team5;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team5.dao.*;

import team5.dao.BigliettoDAO;
import team5.dao.RivenditoreDAO;
import team5.entities.Biglietto;
import team5.entities.Rivenditore;
import team5.dao.MezzoDAO;
import team5.dao.TesseraDAO;
import team5.dao.TrattaDAO;
import team5.dao.UtenteDAO;
import team5.entities.Tessera;
import team5.entities.Tratta;
import team5.entities.Utente;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionetrasporti");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        System.out.println("CIAO");
        Faker faker = new Faker(Locale.ITALY);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        TesseraDAO tesseraDAO = new TesseraDAO(em);
        TrattaDAO trattaDAO = new TrattaDAO(em);
        InServizioDAO inServizioDAO = new InServizioDAO(em);
        MezzoDAO mezzoDAO = new MezzoDAO(em);
        AbbonamentoDAO abbDao = new AbbonamentoDAO(em);


        Supplier<Utente> utenteSupplier = ()-> new Utente(faker.rickAndMorty().character(), faker.name().lastName());
        List<Utente> utenteList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            utenteList.add(utenteSupplier.get());
        }
        utenteList.forEach(utenteDAO::salvaUtente);


    }
    }
