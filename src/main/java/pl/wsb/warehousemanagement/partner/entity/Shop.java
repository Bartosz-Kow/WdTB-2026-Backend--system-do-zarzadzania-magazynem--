package pl.wsb.warehousemanagement.partner.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import pl.wsb.warehousemanagement.account.domain.UserAccount;
import pl.wsb.warehousemanagement.catalog.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "tax_id", nullable = false, unique = true, length = 10)
    private String taxId;

    @Column(name = "contact_email", nullable = false, length = 120)
    private String contactEmail;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", nullable = false, unique = true)
    private UserAccount account;

    @OneToMany(mappedBy = "shop")
    private List<Product> products = new ArrayList<>();

    protected Shop() {
    }

    public Shop(String name, String taxId, String contactEmail, Boolean active, UserAccount account) {
        this.name = name;
        this.taxId = taxId;
        this.contactEmail = contactEmail;
        this.active = active;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTaxId() {
        return taxId;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public Boolean getActive() {
        return active;
    }

    public UserAccount getAccount() {
        return account;
    }

    public List<Product> getProducts() {
        return products;
    }
}
