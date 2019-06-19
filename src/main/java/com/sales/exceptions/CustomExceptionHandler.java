package com.sales.exceptions;

import com.sales.models.SaveResult;
import org.hibernate.JDBCException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<SaveResult> exceptionHandler(Exception e) {

        log.error("An exception has occured :"+ e.getMessage());

        SaveResult response = new SaveResult();

        response.setSaved(false);
        response.setErrorMsg("");
        if ( e.getClass() == JDBCException.class ) {
            response.appendErrorMsg("Error Connecting to the Database.");
        } else {
            response.appendErrorMsg("Internal Server Error.");
        }

        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
