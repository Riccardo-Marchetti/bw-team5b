package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team5.entities.Biglietto;
import team5.entities.Validatrice;
import team5.exception.NotFoundException;

import java.time.LocalDate;

public class ValidatriceDao {
    private final EntityManager em;

    public ValidatriceDao(EntityManager em) {
        this.em = em;
    }

    public void save(Validatrice validatrice) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(validatrice);

        transaction.commit();
        System.out.println("Vidimatrice numero " + validatrice.getId() + "salvata");

    }


    public Validatrice findById(long validatriceId) {
        Validatrice validatrice = em.find(Validatrice.class, validatriceId);
        if (validatrice == null) throw new NotFoundException("Vidimatrice non trovata");
        return validatrice;
    }

    public void vidimazioneBiglietto(Biglietto biglietto) {

        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            if (!biglietto.getVidimato()) {
                biglietto.setDataVidimazione(LocalDate.now());
                biglietto.setVidimato(true);
                em.merge(biglietto);
                transaction.commit();
                System.out.println("Biglietto " + biglietto.getId() + " vidimato");
            } else {
                System.out.println("Biglietto già vidimato");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

