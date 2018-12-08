package br.com.cdc.book.shared;

import br.com.cdc.book.listener.CreatedAuthorEvent;
import br.com.cdc.book.listener.UpdatedAuthorEvent;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Author {

    @Id
    private Long id;

    @NotNull
    private String name;

    /**
     * @deprecated hibernate eyes only
     */
    @Deprecated
    private Author() { }

    public Author(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    public static Author createFrom(CreatedAuthorEvent event) {
        return new Author(event.getId(), event.getName());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void updateName(UpdatedAuthorEvent target) {
        name = target.getToName();
    }
}
