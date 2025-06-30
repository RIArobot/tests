package inventoryservice;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InventoryService {
    private final Map<String, Inventory> inventoryMap = new HashMap<>();

    public InventoryService() {
        // Инициализируем тестовые данные
        inventoryMap.put("1", new Inventory("1", 100));
        inventoryMap.put("2", new Inventory("2", 50));
    }

    public Inventory getInventory(String productId) {
        return inventoryMap.get(productId);
    }
}