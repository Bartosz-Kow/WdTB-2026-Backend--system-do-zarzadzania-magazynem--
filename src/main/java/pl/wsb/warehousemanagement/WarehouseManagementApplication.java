package pl.wsb.warehousemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punkt startowy aplikacji.
 *
 * <p>
 * LAB 01: pakiet {@code pl.wsb.projekt} zmieniony na
 * {@code pl.wsb.warehousemanagement},
 * a klasa {@code ProjektApplication} na {@code WarehouseManagementApplication}
 * (reguła R1.01).
 */

@SpringBootApplication
public class WarehouseManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseManagementApplication.class, args);
    }
}
