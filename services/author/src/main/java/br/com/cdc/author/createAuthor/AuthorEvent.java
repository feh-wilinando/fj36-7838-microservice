package br.com.cdc.author.createAuthor;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface AuthorEvent {
    String CREATED = "authors-created";

    @Output(AuthorEvent.CREATED)
    MessageChannel create();
}
