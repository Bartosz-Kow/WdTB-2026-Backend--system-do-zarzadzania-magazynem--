package pl.wsb.warehousemanagement.movement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.warehousemanagement.movement.entity.StockMovement;

import java.util.List;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

    List<StockMovement> findByItem_SerialNumberOrderByOccurredAtAsc(String serialNumber);
}
