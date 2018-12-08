package br.com.cdc.book.feature.showBook;

import br.com.cdc.book.shared.Book;
import br.com.cdc.client.author.AuthorClient;
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

    Optional<Book> showBookBy(Long id) {
        return repository.findById(id);
    }
}
