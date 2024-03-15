package de.terrazen.zenbreeder.breedingGroup.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BreedingGroupNotFoundException extends RuntimeException {
    public BreedingGroupNotFoundException(String message) {
        super(message);
    }

    public BreedingGroupNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BreedingGroupNotFoundException(Throwable cause) {
        super(cause);
    }

    public BreedingGroupNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
