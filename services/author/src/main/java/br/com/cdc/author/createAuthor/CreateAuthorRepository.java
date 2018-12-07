package br.com.cdc.author.createAuthor;

import br.com.cdc.author.shared.Author;
import org.springframework.data.repository.Repository;

public interface CreateAuthorRepository extends Repository<Author, Long> {
    void save(Author author);
}
