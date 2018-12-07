package br.com.cdc.client.author;

public class AuthorResponse {
    private String name;

    /**
     * @deprecated feign eyes only
     */
    @Deprecated
    private AuthorResponse() { }

    public AuthorResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
