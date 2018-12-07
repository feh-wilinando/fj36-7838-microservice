package br.com.cdc.book.feature.showBook;

import br.com.cdc.book.shared.Book;
import br.com.cdc.client.author.AuthorClient;
import br.com.cdc.client.author.AuthorResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowBookService {

    private final ShowBookRepository repository;
    private final AuthorClient authorCLI;

    public ShowBookService(ShowBookRepository repository, AuthorClient authorCLI) {
        this.repository = repository;
        this.authorCLI = authorCLI;
    }

    Optional<BookView> showBookBy(Long id) {
        return repository.findById(id).map(this::createBookViewBy);
    }

    private BookView createBookViewBy(Book book) {

        AuthorResponse author = authorCLI.loadAuthorBy(book.getAuthorId());

        return new BookView(book, author);
    }
}
