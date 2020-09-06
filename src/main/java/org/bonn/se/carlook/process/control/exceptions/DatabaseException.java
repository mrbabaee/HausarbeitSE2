package org.bonn.se.carlook.process.control.exceptions;

public class DatabaseException extends Exception
{
    private String message;

    public DatabaseException(String message, Exception ex) {
        super(message, ex);
        this.message = message;
    }

    public String getReason() {
        return this.message;
    }

    public void setReason(String reason) {
        this.message = reason;
    }
}
