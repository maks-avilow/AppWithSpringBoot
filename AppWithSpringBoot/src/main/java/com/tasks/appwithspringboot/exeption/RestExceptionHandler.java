package com.tasks.appwithspringboot.exeption;

import com.tasks.appwithspringboot.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value
            = { MyOwnException.class})

    protected ResponseEntity<ErrorDto> handleConflict(RuntimeException ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto(500, "incorrect data/format");

        return ResponseEntity.status(500)
                .header("error", "error")
                .body(errorDto);
    }
}
