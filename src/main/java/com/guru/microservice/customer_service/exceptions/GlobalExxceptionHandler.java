package com.guru.microservice.customer_service.exceptions;

import com.guru.microservice.customer_service.responseDto.ResponseDto;
import com.guru.microservice.customer_service.responseDto.ResponseError;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@Log4j2
@RestControllerAdvice
public class GlobalExxceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(final Exception ex, final WebRequest request, HttpServletResponse response) {
        log.info(ex.getClass().getName());
        log.error("handleAll error", ex);
        final ResponseError error = new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), List.of(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
        ResponseDto responseError = new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), Boolean.FALSE, null, error);
        return new ResponseEntity<>(responseError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler({CustomerNotFoundException.class})
    public ResponseEntity<Object> customerNotFoundException(final CustomerNotFoundException ex, final WebRequest request, HttpServletResponse response) {
        log.info(ex.getClass().getName());
        log.error("customerNotFoundException error", ex);
        final ResponseError error = new ResponseError(HttpStatus.NOT_FOUND.getReasonPhrase(), List.of(ex.getMessage()));
        ResponseDto responseError = new ResponseDto(HttpStatus.NOT_FOUND.value(), Boolean.FALSE, null, error);
        return new ResponseEntity<>(responseError, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
     //   return this.handleExceptionInternal(ex, (Object)null, headers, status, request);
        log.info(ex.getClass().getName());
        log.error("handleNoHandlerFoundException error", ex);
        final String errorMessage = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();
        final ResponseError error = new ResponseError(HttpStatus.NOT_FOUND.getReasonPhrase(), List.of(errorMessage));
        ResponseDto responseError = new ResponseDto(HttpStatus.NOT_FOUND.value(), Boolean.FALSE, null, error);
        return new ResponseEntity<>(responseError, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
