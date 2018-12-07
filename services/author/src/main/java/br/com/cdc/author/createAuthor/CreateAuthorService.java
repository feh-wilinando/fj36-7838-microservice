package br.com.cdc.author.createAuthor;

import br.com.cdc.author.shared.Author;
import org.springframework.stereotype.Service;

@Service
public class CreateAuthorService {

    private final CreateAuthorRepository repository;

    public CreateAuthorService(CreateAuthorRepository repository) {
        this.repository = repository;
    }

    public Long createAuthorBy(CreateAuthorRequest authorRequest) {

        Author author = authorRequest.toDomain();

        repository.save(author);

        return author.getId();
    }
}
