package br.com.cdc.author.showAuthor;

import br.com.cdc.author.shared.Author;

public class AuthorResponse {
    private final Author author;

    public AuthorResponse(Author author) {
        this.author = author;
    }

    public String getName() {
        return author.getName();
    }
}
