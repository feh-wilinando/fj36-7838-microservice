package br.com.cdc.book.feature.createBook;

import br.com.cdc.book.shared.AuthorRepository;
import br.com.cdc.book.shared.Book;
import org.springframework.stereotype.Service;

@Service
public class CreateBookService {

    private final CreateBookRepository repository;
    private AuthorRepository authorRepository;

    public CreateBookService(CreateBookRepository repository, AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    Long createBookBy(CreateBookRequest request) {

        Book book = request.toDomain(authorRepository);

        repository.save(book);

        return book.getId();
    }
}
