package de.terrazen.zenbreeder.species.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SpeciesNotFoundException extends RuntimeException {
    public SpeciesNotFoundException(String message) {
        super(message);
    }

    public SpeciesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpeciesNotFoundException(Throwable cause) {
        super(cause);
    }

    public SpeciesNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
