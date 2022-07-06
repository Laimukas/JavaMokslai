package lt.bit.antr.uzduotis2.DestytojoAliaus;

public class BadRecordException extends RuntimeException {

    private int lineNo;
    private String line;

    public BadRecordException() {
    }

    public BadRecordException(String message) {
        super(message);
    }

    public BadRecordException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRecordException(Throwable cause) {
        super(cause);
    }

    public BadRecordException(int lineNo, String line) {
        this.lineNo = lineNo;
        this.line = line;
    }

    public int getLineNo() {
        return lineNo;
    }

    public String getLine() {
        return line;
    }


}
