package pl.wsb.warehousemanagement.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventory_item")
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false, unique = true, length = 60)
    private String serialNumber;

    @Column(name = "product_sku", nullable = false, length = 40)
    private String productSku;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private InventoryStatus status;

    @Column(name = "received_at", nullable = false)
    private LocalDateTime receivedAt;

    @Embedded
    private StorageLocation location;

    protected InventoryItem() {
    }

    public InventoryItem(String serialNumber, String productSku, InventoryStatus status, LocalDateTime receivedAt,
                         StorageLocation location) {
        this.serialNumber = serialNumber;
        this.productSku = productSku;
        this.status = status;
        this.receivedAt = receivedAt;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getProductSku() {
        return productSku;
    }

    public InventoryStatus getStatus() {
        return status;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public StorageLocation getLocation() {
        return location;
    }
}
