package pl.wsb.warehousemanagement.fulfillment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import pl.wsb.warehousemanagement.inventory.entity.InventoryItem;
import pl.wsb.warehousemanagement.partner.entity.Shop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "issue_order")
public class IssueOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number", nullable = false, unique = true, length = 30)
    private String orderNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private IssueOrderStatus status;

    @Column(name = "requested_at", nullable = false)
    private LocalDateTime requestedAt;

    @Column(name = "recipient_name", nullable = false, length = 100)
    private String recipientName;

    @Column(name = "delivery_address", nullable = false, length = 200)
    private String deliveryAddress;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @OneToMany(mappedBy = "order")
    private List<IssueOrderLine> lines = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "issue_order_item",
            joinColumns = @JoinColumn(name = "issue_order_id"),
            inverseJoinColumns = @JoinColumn(name = "inventory_item_id"))
    private Set<InventoryItem> pickedItems = new HashSet<>();

    protected IssueOrder() {
    }

    public IssueOrder(String orderNumber, IssueOrderStatus status, LocalDateTime requestedAt, String recipientName,
                      String deliveryAddress, Shop shop) {
        this.orderNumber = orderNumber;
        this.status = status;
        this.requestedAt = requestedAt;
        this.recipientName = recipientName;
        this.deliveryAddress = deliveryAddress;
        this.shop = shop;
    }

    public Long getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public IssueOrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Shop getShop() {
        return shop;
    }

    public List<IssueOrderLine> getLines() {
        return lines;
    }

    public Set<InventoryItem> getPickedItems() {
        return pickedItems;
    }
}
