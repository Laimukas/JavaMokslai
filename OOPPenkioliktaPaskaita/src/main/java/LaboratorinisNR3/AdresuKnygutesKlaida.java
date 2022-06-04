package LaboratorinisNR3;

public class AdresuKnygutesKlaida extends Exception{

    public AdresuKnygutesKlaida(String message, Throwable cause){
        super(message, cause);
    }
    public AdresuKnygutesKlaida(String message){
        super(message);
    }
}
