package br.com.fuzusnoary.passrepositoryapi.services.exceptions;

public class UserNotAllowedException extends RuntimeException {
    private static final long serialVersionID = 1L;

    public UserNotAllowedException(String msg) {
        super(msg);
    }
}
