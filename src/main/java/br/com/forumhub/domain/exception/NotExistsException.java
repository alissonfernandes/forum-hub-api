package br.com.forumhub.domain.exception;

public class NotExistsException extends RuntimeException{
    public NotExistsException(String message) {
        super(message);
    }
}
