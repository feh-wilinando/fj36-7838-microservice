package br.com.cdc.book.feature.showBook;

import br.com.cdc.book.shared.Book;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ShowBookRepository extends Repository<Book, Long> {
    Optional<Book> findById(Long id);
}
