package pl.wsb.warehousemanagement.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.warehousemanagement.inventory.entity.InventoryItem;

import java.util.List;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    List<InventoryItem> findByProduct_Sku(String sku);

    List<InventoryItem> findByProduct_Shop_Name(String shopName);
}
