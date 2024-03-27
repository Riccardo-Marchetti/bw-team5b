package team5.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {

        super("Il record con id " + id + " non è stato trovato!");
    }

    public NotFoundException(String partecipazioneNonTrovata) {


    }
}
