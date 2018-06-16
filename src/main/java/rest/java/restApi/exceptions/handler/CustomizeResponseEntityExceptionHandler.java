package rest.java.restApi.exceptions.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import rest.java.restApi.exceptions.userNotFoundException;
import rest.java.restApi.exceptions.ExceptionResponse;
import rest.java.restApi.exceptions.UserExistsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(userNotFoundException.class)
    public final ResponseEntity handleUserNotFoundExc(userNotFoundException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));

                return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserExistsException.class)
    public final ResponseEntity handleUserExistsExc(UserExistsException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity handleUserExistsExc(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders header, HttpStatus status,
                                                                  WebRequest request){
        List<String> listOfErrors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().stream().
                forEach(e -> listOfErrors.
                        add(listOfErrors.size() + 1 + " " + e.getDefaultMessage()));
        ExceptionResponse response = new ExceptionResponse(new Date(),
                "validation failed", listOfErrors.toString());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

}
