package com.product.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class RestExceptionHandler extends ReponseEntityExceptionHandler {
    
    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<ExceptionResponse> handleApiException(ApiException ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setTimestamp(LocalDateTime.now());
        exceptionResponse.setStatus(ex.getStatus().value());
        exceptionResponse.setError(ex.getStatus());
        exceptionResponse.setMessage(ex.getMessage());
        exceptionResponse.setPath(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getRequestURI());
        return new ResponseEntity<>(exceptionResponse, ex.getStatus());
    }

}
