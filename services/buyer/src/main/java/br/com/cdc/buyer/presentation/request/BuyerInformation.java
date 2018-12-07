package br.com.cdc.buyer.presentation.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class BuyerInformation {

    private String email;
    private String name;

    /**
     * @deprecated jackson eyes only
     */
    @Deprecated
    private BuyerInformation() { }

    public BuyerInformation(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public @NotBlank String getName() {
        return name;
    }

    public @Email @NotBlank String getEmail() {
        return email;
    }
}
