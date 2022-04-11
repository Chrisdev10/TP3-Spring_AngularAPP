package be.technifutur.sportaddict.controllers;

import be.technifutur.sportaddict.dto.ErrorDTO;
import be.technifutur.sportaddict.exception.ElementNotFoundException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorControllerHandler {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleElementNotFound(ElementNotFoundException ex, HttpServletRequest req){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorDTO.builder()
                                .message(ex.getMessage())
                                .method(HttpMethod.resolve(req.getMethod()))
                                .status(HttpStatus.NOT_FOUND)
                                .uri(req.getRequestURI())
                                .build()
                );
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> validatorTriggered(MethodArgumentNotValidException ex, HttpServletRequest req){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        ErrorDTO.builder()
                                .message(ex.getMessage())
                                .method(HttpMethod.resolve(req.getMethod()))
                                .status(HttpStatus.BAD_REQUEST)
                                .uri(req.getRequestURI())
                                .build()
                );
    }
}
