package co.udea.ssmu.api.model.jpa.repository.vehicles;

import co.udea.ssmu.api.model.jpa.model.vehicles.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("SELECT v FROM Vehicle v WHERE UPPER(v.name) = UPPER(:name)")
    Optional<Vehicle> findByName(@Param("name") String name);
}
