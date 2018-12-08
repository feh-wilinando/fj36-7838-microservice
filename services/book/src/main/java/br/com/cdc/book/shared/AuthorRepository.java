package br.com.cdc.book.shared;

import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface AuthorRepository extends Repository<Author, Long> {
    Optional<Author> findById(Long authorId);

    void save(Author from);
}
