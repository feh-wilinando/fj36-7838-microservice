package br.com.cdc.book.listener;

import br.com.cdc.book.shared.Author;
import br.com.cdc.book.shared.AuthorRepository;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(AuthorEvent.class)
public class AuthorListener {



    private final AuthorRepository repository;

    public AuthorListener(AuthorRepository repository) {
        this.repository = repository;
    }

    @StreamListener(AuthorEvent.CREATED)
    public void created(CreatedAuthorEvent event) {

        System.out.println("\n\n\n CREATED");
        System.out.println(event);
        System.out.println("\n\n\n---");

        repository.save(Author.createFrom(event));
    }

    @StreamListener(AuthorEvent.UPDATED)
    public void updated(UpdatedAuthorEvent event) {
        System.out.println("\n\n\n updated");
        System.out.println(event);
        System.out.println("\n\n\n---");
        repository.findById(event.getId())
                .ifPresent(author -> author.updateName(event));
    }
}
