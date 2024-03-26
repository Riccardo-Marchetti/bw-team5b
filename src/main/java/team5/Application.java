package team5;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team5.dao.*;

import team5.dao.BigliettoDAO;
import team5.dao.RivenditoreDAO;
import team5.entities.*;
import team5.dao.MezzoDAO;
import team5.dao.TesseraDAO;
import team5.dao.TrattaDAO;
import team5.dao.UtenteDAO;
import team5.enums.StatoDeiMezzi;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionetrasporti");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        System.out.println("CIAO");
        Faker faker = new Faker(Locale.ITALY);
        Random rndm = new Random();
        UtenteDAO utenteDAO = new UtenteDAO(em);
        TesseraDAO tesseraDAO = new TesseraDAO(em);
        TrattaDAO trattaDAO = new TrattaDAO(em);
        ManutenzioneDAO manutenzioneDAO = new ManutenzioneDAO(em);
        TramDAO tramDAO = new TramDAO(em);
        AutobusDAO autobusDAO = new AutobusDAO(em);

       Manutenzione manutenzione1 = new Manutenzione(LocalDate.now(),LocalDate.of(2024,03,27),"Guasto motore");
        manutenzioneDAO.save(manutenzione1);

        Tram tram1 = new Tram(100,01,false,manutenzione1,null);
        tramDAO.save(tram1);

        Tratta tratta1 = new Tratta("Roma", "Milano",300);
        trattaDAO.save(tratta1);

        Tram tram2 = new Tram(150,02,true,null,tratta1);
        tramDAO.save(tram2);











        /*
         * Supplier<Utente> utenteSupplier = ()->{
         * Faker faker = new Faker(Locale.ITALY);
         * return new Utente(faker.rickAndMorty().character(), )
         * 
         * };
         */

        // Create a new tratta
        // Supplier<Tratta> trattaSupplier = () -> {
        // };

    }
}
