package in.hp.boot.userinfoservice.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GenericException {
    private final String timestamp;
    private final String message;
    private final String details;
}
