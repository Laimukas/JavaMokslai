package lt.bit.penkt.klaidos;

public class ManoUncheckedKlaida extends RuntimeException {

    public ManoUncheckedKlaida() {
    }

    public ManoUncheckedKlaida(String message) {
        super(message);
    }

    public ManoUncheckedKlaida(String message, Throwable cause) {
        super(message, cause);
    }

    public ManoUncheckedKlaida(Throwable cause) {
        super(cause);
    }

}