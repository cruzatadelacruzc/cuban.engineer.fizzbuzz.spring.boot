package cuban.engineer.fizzbuzz.web.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.BAD_REQUEST)
public class WrongBoundaryException extends Exception {


    public WrongBoundaryException(String message) {
        super("FizzBuzz says: " + message);
    }
}
