package lt.bit.exceptions;

public class Skaiciuotuvas {

    public static int division(int a, int b) throws SkaiciuotuvoKlaidos {
        try {
            return a / b;
        } catch (ArithmeticException e){
            throw new SkaiciuotuvoKlaidos("Ivyko klaida, skaiciuotuvas nesugeba atlikti tokios operacijos, nes: " + e.getMessage(),
                   e);
        }
    }
}
