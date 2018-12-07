package br.com.cdc.author.showAuthor;

import br.com.cdc.author.shared.Author;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ShowAuthorResporitory extends Repository<Author, Long> {
    Optional<Author> findById(Long id);
}
