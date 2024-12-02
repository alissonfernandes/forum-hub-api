package br.com.forumhub.domain.exception;

public class ExistingTopicException  extends RuntimeException{
    public ExistingTopicException(String message) {
        super(message);
    }
}
