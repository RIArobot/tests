package orderservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    private Long id;
    private String productId;
    private int quantity;
    private boolean completed;

    // Конструктор по умолчанию (обязателен для Jackson)
    public Order() {}

    // Аннотированный конструктор для создания объекта из JSON
    @JsonCreator
    public Order(
            @JsonProperty("productId") String productId,
            @JsonProperty("quantity") int quantity
    ) {
        this.productId = productId;
        this.quantity = quantity;
    }


    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCompleted(boolean b) {
        this.completed = b;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Object getId() {
        return id;
    }

    public boolean isCompleted() {
        return completed;
    }
}