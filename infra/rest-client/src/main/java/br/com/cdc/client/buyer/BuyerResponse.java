package br.com.cdc.client.buyer;

public class BuyerResponse {
    private String name;
    private String email;

    /**
     * @deprecated feign eyes only
     */
    @Deprecated
    private BuyerResponse() { }

    public BuyerResponse(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
