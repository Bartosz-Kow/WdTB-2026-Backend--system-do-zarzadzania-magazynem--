package pl.wsb.warehousemanagement.movement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock_movement")
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false, length = 60)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "movement_type", nullable = false, length = 20)
    private MovementType movementType;

    @Column(name = "occurred_at", nullable = false)
    private LocalDateTime occurredAt;

    @Column(name = "source_location", length = 80)
    private String sourceLocation;

    @Column(name = "destination_location", length = 80)
    private String destinationLocation;

    @Column(name = "performed_by", nullable = false, length = 120)
    private String performedBy;

    protected StockMovement() {
    }

    public StockMovement(String serialNumber, MovementType movementType, LocalDateTime occurredAt,
                         String sourceLocation, String destinationLocation, String performedBy) {
        this.serialNumber = serialNumber;
        this.movementType = movementType;
        this.occurredAt = occurredAt;
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
        this.performedBy = performedBy;
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
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

    public String getPerformedBy() {
        return performedBy;
    }
}
