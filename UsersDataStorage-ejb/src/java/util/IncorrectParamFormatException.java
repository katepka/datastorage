package util;

public class IncorrectParamFormatException extends Exception {
    private String message;

    public IncorrectParamFormatException(String message) {
        this.message = message;
    }
    
}
