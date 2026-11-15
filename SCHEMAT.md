# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 8 (w tym tabele łączące @ManyToMany: issue_order_item) · kolumny: 47 · relacje: 7 × @ManyToOne, 3 × @OneToMany, 1 × @OneToOne, 1 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| inventory_item | InventoryItem | 9 | product_id |
| issue_order | IssueOrder | 7 | shop_id |
| issue_order_line | IssueOrderLine | 5 | issue_order_id, product_id |
| product | Product | 8 | shop_id |
| shop | Shop | 6 | user_account_id |
| stock_movement | StockMovement | 7 | inventory_item_id, user_account_id |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    inventory_item {
        Long id PK
        String aisle
        String bin
        Long product_id FK
        String rack
        LocalDateTime received_at
        String serial_number
        InventoryStatus status
        String zone
    }
    issue_order {
        Long id PK
        String delivery_address
        String order_number
        String recipient_name
        LocalDateTime requested_at
        Long shop_id FK
        IssueOrderStatus status
    }
    issue_order_line {
        Long id PK
        Long issue_order_id FK
        String note
        Long product_id FK
        Integer quantity
    }
    product {
        Long id PK
        Boolean active
        ProductCategory category
        LocalDate introduced_on
        String name
        Long shop_id FK
        String sku
        BigDecimal unit_price
    }
    shop {
        Long id PK
        Boolean active
        String contact_email
        String name
        String tax_id
        Long user_account_id FK
    }
    stock_movement {
        Long id PK
        String destination_location
        Long inventory_item_id FK
        MovementType movement_type
        LocalDateTime occurred_at
        String source_location
        Long user_account_id FK
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    inventory_item ||--o{ stock_movement : "inventory_item_id"
    issue_order ||--o{ issue_order_line : "issue_order_id"
    issue_order }o--o{ inventory_item : "issue_order_item"
    product ||--o{ inventory_item : "product_id"
    product ||--o{ issue_order_line : "product_id"
    shop ||--o{ issue_order : "shop_id"
    shop ||--o{ product : "shop_id"
    user_account ||--o{ stock_movement : "user_account_id"
    user_account ||--o| shop : "user_account_id"
```
