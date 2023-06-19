package fr.dawudesign.dza.exeptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class WebErrorMapper {
    public  WebError map(ParametrizeMessageException pme) {
        String messageDefault = pme.getDefaultMessage();
        return  new WebError(
                pme.getHttpStatus().value(),
                pme.getHttpStatus(),
                new Date(),
                pme.getCodeMessage(),
                messageDefault,
                pme.getParams());
    }
    public  WebError map(Exception e) {
        return  new WebError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                new Date(),
                "INTERNAL_SERVER_ERROR",
                e.getMessage()
        );
    }

    public WebError map(OperationNonPermittedException e) {
        return new WebError(
                HttpStatus.FORBIDDEN.value(),
                HttpStatus.FORBIDDEN,
                new Date(),
                "OPERATION_NON_PERMITTED",
                e.getMessage()
        );
    }

    public WebError map(ObjectValidationException e) {
        return new WebError(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                new Date(),
                "OBJECT_VALIDATION_ERROR",
                e.getMessage(),
                e.getViolations()
        );
    }
}
