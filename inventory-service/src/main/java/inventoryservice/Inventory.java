package inventoryservice;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Inventory {
    private String productId;
    private int quantity;

    // Конструктор по умолчанию (обязателен для Jackson)
    public Inventory() {}

    // Аннотированный конструктор для десериализации
    @JsonCreator
    public Inventory(
            @JsonProperty("productId") String productId,
            @JsonProperty("quantity") int quantity
    ) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductId() {
        return productId;
    }
}