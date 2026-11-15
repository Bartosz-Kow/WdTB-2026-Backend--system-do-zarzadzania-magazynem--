package pl.wsb.warehousemanagement.fulfillment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pl.wsb.warehousemanagement.catalog.entity.Product;

@Entity
@Table(name = "issue_order_line")
public class IssueOrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "issue_order_id", nullable = false)
    private IssueOrder order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "note", length = 120)
    private String note;

    protected IssueOrderLine() {
    }

    public IssueOrderLine(IssueOrder order, Product product, Integer quantity, String note) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public IssueOrder getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getNote() {
        return note;
    }
}
