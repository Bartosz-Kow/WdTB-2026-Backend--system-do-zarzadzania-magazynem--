package pl.wsb.warehousemanagement.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pl.wsb.warehousemanagement.catalog.entity.Product;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventory_item")
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false, unique = true, length = 60)
    private String serialNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private InventoryStatus status;

    @Column(name = "received_at", nullable = false)
    private LocalDateTime receivedAt;

    @Embedded
    private StorageLocation location;

    protected InventoryItem() {
    }

    public InventoryItem(String serialNumber, Product product, InventoryStatus status, LocalDateTime receivedAt,
                         StorageLocation location) {
        this.serialNumber = serialNumber;
        this.product = product;
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

    public Product getProduct() {
        return product;
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
