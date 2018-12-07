package br.com.cdc.author.createAuthor;

import br.com.cdc.author.shared.Author;

import javax.validation.constraints.NotBlank;

public class CreateAuthorRequest {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author toDomain() {
        return new Author(name);
    }
}
