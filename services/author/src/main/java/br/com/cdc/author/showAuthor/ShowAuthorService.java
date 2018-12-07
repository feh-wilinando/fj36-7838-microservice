package br.com.cdc.author.showAuthor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowAuthorService {
    private final ShowAuthorResporitory repository;

    public ShowAuthorService(ShowAuthorResporitory repository) {
        this.repository = repository;
    }

    public Optional<AuthorResponse> loadAuthorBy(Long id) {
        return repository.findById(id).map(AuthorResponse::new);
    }
}
