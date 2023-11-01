package co.udea.ssmu.api.model.jpa.repository.trip;

import co.udea.ssmu.api.model.jpa.model.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {
}
