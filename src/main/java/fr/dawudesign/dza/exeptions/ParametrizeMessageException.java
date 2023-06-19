package fr.dawudesign.dza.exeptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ParametrizeMessageException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String codeMessage;
    private final String DefaultMessage;
    private final Object params;

    public ParametrizeMessageException(
            HttpStatus httpStatus,
            String codeMessage,
            String defaultMessage,
            Object... params
    ) {
        this(null, httpStatus, codeMessage, defaultMessage, params);
    }
    public ParametrizeMessageException(
            Throwable cause,
            HttpStatus httpStatus,
            String codeMessage,
            String defaultMessage,
            Object... params
    ) {
        super(codeMessage, cause);
        this.httpStatus = httpStatus;
        this.codeMessage = codeMessage;
        this.DefaultMessage = defaultMessage;
        this.params = params;
    }
}
