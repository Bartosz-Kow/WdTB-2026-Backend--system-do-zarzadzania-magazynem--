package pl.wsb.warehousemanagement.movement.entity;

import jakarta.persistence.Column;
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
import pl.wsb.warehousemanagement.account.domain.UserAccount;
import pl.wsb.warehousemanagement.inventory.entity.InventoryItem;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock_movement")
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventory_item_id", nullable = false)
    private InventoryItem item;

    @Enumerated(EnumType.STRING)
    @Column(name = "movement_type", nullable = false, length = 20)
    private MovementType movementType;

    @Column(name = "occurred_at", nullable = false)
    private LocalDateTime occurredAt;

    @Column(name = "source_location", length = 80)
    private String sourceLocation;

    @Column(name = "destination_location", length = 80)
    private String destinationLocation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount performedBy;

    protected StockMovement() {
    }

    public StockMovement(InventoryItem item, MovementType movementType, LocalDateTime occurredAt,
                         String sourceLocation, String destinationLocation, UserAccount performedBy) {
        this.item = item;
        this.movementType = movementType;
        this.occurredAt = occurredAt;
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
        this.performedBy = performedBy;
    }

    public Long getId() {
        return id;
    }

    public InventoryItem getItem() {
        return item;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public UserAccount getPerformedBy() {
        return performedBy;
    }
}
