package pl.wsb.warehousemanagement.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class StorageLocation {

    @Column(name = "zone", nullable = false, length = 20)
    private String zone;

    @Column(name = "aisle", nullable = false, length = 10)
    private String aisle;

    @Column(name = "rack", nullable = false, length = 10)
    private String rack;

    @Column(name = "bin", nullable = false, length = 10)
    private String bin;

    protected StorageLocation() {
    }

    public StorageLocation(String zone, String aisle, String rack, String bin) {
        this.zone = zone;
        this.aisle = aisle;
        this.rack = rack;
        this.bin = bin;
    }

    public String getZone() {
        return zone;
    }

    public String getAisle() {
        return aisle;
    }

    public String getRack() {
        return rack;
    }

    public String getBin() {
        return bin;
    }
}
