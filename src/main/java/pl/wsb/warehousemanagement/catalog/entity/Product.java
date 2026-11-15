package pl.wsb.warehousemanagement.catalog.entity;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import pl.wsb.warehousemanagement.inventory.entity.InventoryItem;
import pl.wsb.warehousemanagement.partner.entity.Shop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sku", nullable = false, unique = true, length = 40)
    private String sku;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 20)
    private ProductCategory category;

    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "introduced_on", nullable = false)
    private LocalDate introducedOn;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @OneToMany(mappedBy = "product")
    private List<InventoryItem> items = new ArrayList<>();

    protected Product() {
    }

    public Product(String sku, String name, ProductCategory category, BigDecimal unitPrice, Boolean active,
                   LocalDate introducedOn, Shop shop) {
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.unitPrice = unitPrice;
        this.active = active;
        this.introducedOn = introducedOn;
        this.shop = shop;
    }

    public Long getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDate getIntroducedOn() {
        return introducedOn;
    }

    public Shop getShop() {
        return shop;
    }

    public List<InventoryItem> getItems() {
        return items;
    }
}
