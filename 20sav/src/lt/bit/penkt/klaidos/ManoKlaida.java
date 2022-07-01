package lt.bit.penkt.klaidos;

public class ManoKlaida extends Exception {

    public ManoKlaida() {
    }

    public ManoKlaida(String message) {
        super(message);
    }

    public ManoKlaida(String message, Throwable cause) {
        super(message, cause);
    }

    public ManoKlaida(Throwable cause) {
        super(cause);
    }

}

