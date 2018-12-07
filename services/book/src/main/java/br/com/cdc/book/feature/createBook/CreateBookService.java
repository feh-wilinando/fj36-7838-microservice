package br.com.cdc.book.feature.createBook;

import br.com.cdc.book.shared.Book;
import org.springframework.stereotype.Service;

@Service
public class CreateBookService {

    private final CreateBookRepository repository;

    public CreateBookService(CreateBookRepository repository) {
        this.repository = repository;
    }

    Long createBookBy(CreateBookRequest request) {

        Book book = request.toDomain();

        repository.save(book);

        return book.getId();
    }
}
