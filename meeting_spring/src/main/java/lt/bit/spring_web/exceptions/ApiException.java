package lt.bit.spring_web.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException{
    private final HttpStatus httpStatus;
    public ApiException(String message, int httpStatus) {
        super(message);
        this.httpStatus = HttpStatus.valueOf(httpStatus);
    }
}
