package br.com.cdc.author.createAuthor;

import br.com.cdc.author.shared.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(AuthorEvent.class)
public class CreateAuthorService {

    @Autowired
    private CreateAuthorRepository repository;

    @Autowired
    private AuthorEvent event;


    public Long createAuthorBy(CreateAuthorRequest authorRequest) {

        Author author = authorRequest.toDomain();

        repository.save(author);

        Message<Author> message = MessageBuilder.withPayload(author).build();

        event.create().send(message);

        return author.getId();
    }
}
