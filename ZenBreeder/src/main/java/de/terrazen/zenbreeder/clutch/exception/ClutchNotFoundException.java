package de.terrazen.zenbreeder.clutch.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClutchNotFoundException extends RuntimeException {
    public ClutchNotFoundException(String message) {
        super(message);
    }

    public ClutchNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClutchNotFoundException(Throwable cause) {
        super(cause);
    }

    public ClutchNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
