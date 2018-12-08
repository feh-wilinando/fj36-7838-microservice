package br.com.cdc.book.listener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface AuthorEvent {
    String CREATED = "authors-created";
    String UPDATED = "authors-updated";

    @Input(CREATED)
    MessageChannel created();

    @Input(UPDATED)
    MessageChannel updated();
}
