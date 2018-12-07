package br.com.cdc.purchase.feature.showPurchase;

import br.com.cdc.client.book.BookClient;
import br.com.cdc.client.buyer.BuyerClient;
import br.com.cdc.client.buyer.BuyerResponse;
import br.com.cdc.purchase.shared.Product;
import br.com.cdc.purchase.shared.Purchase;
import br.com.cdc.purchase.shared.dtos.CreatedPurchase;
import br.com.cdc.purchase.shared.dtos.ProductItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ShowPurchaseService {
    private final ShowPurchaseRepository repository;
    private final BuyerClient buyerCLI;
    private final BookClient bookCLI;

    public ShowPurchaseService(ShowPurchaseRepository repository, BuyerClient buyerCLI, BookClient bookCLI) {
        this.repository = repository;
        this.buyerCLI = buyerCLI;
        this.bookCLI = bookCLI;
    }

    Optional<CreatedPurchase> show(Long id) {
        return repository.findById(id).map(this::createPurchaseResponse);
    }

    private CreatedPurchase createPurchaseResponse(Purchase purchase) {
        BuyerResponse buyer = buyerCLI.loadBuyerBy(purchase.getUserId());

        List<ProductItem> items = mapProductsToProductItems(purchase.getProducts());

        return new CreatedPurchase(purchase, buyer, items);
    }

    private List<ProductItem> mapProductsToProductItems(List<Product> products) {
        return products.stream()
                .map(Product::getId)
                    .map(bookCLI::loadBookBy)
                        .map(ProductItem::new)
                            .collect(toList());
    }
}
