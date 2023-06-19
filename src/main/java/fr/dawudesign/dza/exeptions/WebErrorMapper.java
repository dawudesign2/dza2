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
}
