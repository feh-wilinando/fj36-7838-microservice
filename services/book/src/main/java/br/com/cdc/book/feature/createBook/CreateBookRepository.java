package br.com.cdc.book.feature.createBook;

import br.com.cdc.book.shared.Book;
import org.springframework.data.repository.Repository;

interface CreateBookRepository extends Repository<Book, Long> {
    void save(Book book);
}
