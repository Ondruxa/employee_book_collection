package pro.sky.homework.employbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeHasInvalidCharacter extends RuntimeException{
    public EmployeeHasInvalidCharacter() {

    }

    public EmployeeHasInvalidCharacter(String message) {
        super(message);
    }

    public EmployeeHasInvalidCharacter(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeHasInvalidCharacter(Throwable cause) {
        super(cause);
    }

    public EmployeeHasInvalidCharacter(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
