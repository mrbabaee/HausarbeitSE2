package org.bonn.se.carlook.process.control.exceptions;

public class VertrieblerSchonRegistriertException extends Exception {
    public VertrieblerSchonRegistriertException(){
        super("CompanyAlreadyRegisteredException", null);
    }
}
