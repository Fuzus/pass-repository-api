package br.com.fuzusnoary.passrepositoryapi.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionID = 1L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
