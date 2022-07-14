package lt.bit.ketv.studentas;

public class BlogasPazymysException extends Exception{
    public BlogasPazymysException(String message, Throwable cause){
        super(message, cause);
    }
    public BlogasPazymysException(String message){
        super(message);
    }
}