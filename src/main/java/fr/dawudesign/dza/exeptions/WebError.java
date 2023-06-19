package fr.dawudesign.dza.exeptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public record WebError(
        int httpStatusCode,
        HttpStatus httpStatus,
        Date timestamp,
        String codeMessage,
        String defaultMessage,
        Object... args
) {
}
