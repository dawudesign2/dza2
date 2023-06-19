package fr.dawudesign.dza.exeptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExceptionRepresentation {
    private String errorMessage;
    private String errorSrc;
    private Set<String> errorValidation;
}
