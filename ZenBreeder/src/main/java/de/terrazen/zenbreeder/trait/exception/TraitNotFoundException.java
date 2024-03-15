package de.terrazen.zenbreeder.trait.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TraitNotFoundException extends RuntimeException {
    public TraitNotFoundException(String message) {
        super(message);
    }

    public TraitNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TraitNotFoundException(Throwable cause) {
        super(cause);
    }

    public TraitNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
