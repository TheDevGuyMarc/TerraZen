package de.terrazen.zenbreeder.enclosure.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EnclosureNotFoundException extends RuntimeException {
    public EnclosureNotFoundException(String message) {
        super(message);
    }

    public EnclosureNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EnclosureNotFoundException(Throwable cause) {
        super(cause);
    }

    public EnclosureNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
